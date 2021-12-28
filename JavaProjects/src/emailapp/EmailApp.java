package emailapp;

public class EmailApp {

	public static void main(String[] args) {
		
		Email em1 = new Email("Jackie", "Allam");
		
		em1.setMailboxSize(1000);
		em1.changePassword("mysecret123");
		em1.setAltEmail("jackieallam@mailbox.org");
		
//		System.out.println(em1.getName());
//		System.out.println(em1.getMailboxSize());
//		System.out.println(em1.getEmail());
//		System.out.println(em1.getAltEmail());
		
		System.out.println(em1.showInfo());

	}

}
