import java.util.Date;

class JavaTest {
	public static void main(String[] args) {
		System.out.println("prepare");
		StringBuffer sb = new StringBuffer("abc");

		Object sb2 = new Date();
		String str = sb2 + new String("abc");

		System.out.println("StringBuffer: " + sb.hashCode());
		 System.out.println("String: " + str);

	}
}
