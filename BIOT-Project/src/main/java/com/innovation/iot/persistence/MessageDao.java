package com.innovation.iot.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.innovation.iot.domain.Device;
import com.innovation.iot.domain.Message;
import com.innovation.iot.domain.MessageContent;
import com.innovation.iot.domain.User;

public class MessageDao {

	public List<Message> getMessages(String deviceId, String userCode) throws SQLException, ClassNotFoundException {
		List<Message> messages = new ArrayList<>();
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(getQuery());) {
			ps.setString(1, deviceId);
			ps.setString(2, userCode);
			ps.setString(3, userCode);
			try (ResultSet rs = ps.executeQuery();) {
				int messageId = 0;
				List<MessageContent> contents = null;
				while (rs.next()) {
					if( messageId != rs.getInt(1)){
						contents = new ArrayList<>();
						messages.add( new Message( rs.getInt(1), contents, rs.getString(2), rs.getString(3), rs.getDate(4) ));
						contents.add(new MessageContent( rs.getString(5), rs.getString(6)));
						messageId = rs.getInt(1);
					}else{
						contents.add(new MessageContent( rs.getString(5), rs.getString(6)));
						messageId = rs.getInt(1);
					}
				}
			}
		}
		return messages;
	}

	public User getUser(String code) throws SQLException, ClassNotFoundException {
		User user = null;
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement("select code, name, image_url, date_of_birth from bi_ma_user where code = ?");) {
			ps.setString(1, code);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4));
				}
			}
		}
		return user;
	}

	public Device getDevice(String code) throws SQLException, ClassNotFoundException {
		Device device = null;
		try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement("select id, description, location from bi_ma_device where id = ?");) {
			ps.setString(1, code);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					device = new Device(rs.getString(1), rs.getString(2), rs.getString(3));
				}
			}
		}
		return device;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/beacon?user=root&password=");
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(getConnection());
	}
	
	

	private static String getQuery() {
		StringBuilder query = new StringBuilder();
		query.append(" select");
		query.append(" q.id,");
		query.append(" q.created,");
		query.append(" q.userImage,");
		query.append(" q.startdate,");
		query.append(" q.content,");
		query.append(" q.msgImage");
		query.append(" from");
		query.append(" (select ");
		query.append(" msg.id id,");
		query.append(" msg.created created,");
		query.append(" usr.image_url userImage,");
		query.append(" msg.start_date startdate,");
		query.append(" msgcont.content content,");
		query.append(" msgcont.image_url msgImage");
		query.append(" from");
		query.append(" bi_tr_message msg, bi_lk_profile_device prf_dev, bi_lk_message_profile msg_prf, bi_lk_user_profile usr_prf, bi_ma_user usr, bi_tr_message_content msgcont");
		query.append(" where");
		query.append(" prf_dev.profile_id = msg_prf.profile_id");
		query.append(" and msg_prf.message_id = msg.id");
		query.append(" and usr_prf.profile_id = msg_prf.profile_id");
		query.append(" and usr_prf.profile_id = prf_dev.profile_id");
		query.append(" and usr.code = usr_prf.user_code");
		query.append(" and msg.id = msgcont.message_id");
		query.append(" and (now() between msg.start_date and msg.end_date)");
		query.append(" and prf_dev.device_id = ?");
		query.append(" and usr_prf.user_code = ? ");
		query.append(" union ");
		query.append(" select ");
		query.append(" msg.id id,");
		query.append(" msg.created created,");
		query.append(" usr.image_url userImage,");
		query.append(" msg.start_date startdate,");
		query.append(" msgcont.content content,");
		query.append(" msgcont.image_url msgImage");
		query.append(" from");
		query.append(" bi_tr_message msg, bi_lk_message_user msg_usr, bi_ma_user usr, bi_tr_message_content msgcont");
		query.append(" where");
		query.append(" msg_usr.message_id = msg.id");
		query.append(" and usr.code = msg_usr.user_code");
		query.append(" and msg.id = msgcont.message_id");
		query.append(" and (now() between msg.start_date and msg.end_date)");
		query.append(" and msg_usr.user_code = ?) q");
		query.append(" order by q.id asc;");
		return query.toString();
	}

}
