package day0822;

public class RunDog {
	Pooldle d = new Pooldle(2, 4, 2, 1);
	Pome p = new Pome(2, 4, 2, 1);

	public void printDog() {
		System.out.println(p.eat());
		System.out.println(p.eat("닭고기가 들어간"));

		p.walking(2);
		p.walking(4);
		System.out.println(p.getJump());
		System.out.println(p.jumpBed());
		System.out.println("--------------------");

		System.out.println(d.eat());
		System.out.println(d.eat("닭가슴살"));

		d.training(2);
		d.training(7);
		d.training(7);
		d.training(7);
		System.out.println(d.getlevel());
		System.out.println(d.trainingLevel());

	}

	public static void main(String[] args) {
		RunDog rd = new RunDog();
		rd.printDog();
	}

}
