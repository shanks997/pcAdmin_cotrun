package netUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utility.Constant;

public class NetIO {
	
	public static Socket sk = null;
	public static DataInputStream dis;
	public static DataOutputStream dos;
	public static String message = "";
	public static int count;
	public static Boolean flag;
	static Lock lock = new ReentrantLock();
	
	// 通信建立，连接到服务端
	public static void connect() throws Exception {
		lock.lock();
		sk = new Socket("127.0.0.1", 9998);
		dis = new DataInputStream(sk.getInputStream());
		dos = new DataOutputStream(sk.getOutputStream());
	}
	
	public static void disConnect() {
		if (dos != null)
			try {
				
				dos.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		if (dis != null)
			try {
				dis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		if (sk != null)
			try {
				sk.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		lock.unlock();
	}
	
	public static void initInfo() {
		try {
			connect();
			dos.writeUTF(Constant.INIT_INFO);
			String str = dis.readUTF();
			System.out.println("str " + str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}
	
	public static Boolean isManager(String info) {
		try {
			connect();
			dos.writeUTF(Constant.IS_MANAGER + info);
			flag = dis.readBoolean();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return flag;
	}

}
