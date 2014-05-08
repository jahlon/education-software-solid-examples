package worker.mode.refactored;

public class ManWorker implements IWorker {

	@Override
	public void eat() {
		System.out.println("ManWorker is eating");
	}

	@Override
	public void work() {
		System.out.println("ManWorker is working");
	}

	@Override
	public void sleep() {
		System.out.println("ManWorker is sleeping");
	}

}
