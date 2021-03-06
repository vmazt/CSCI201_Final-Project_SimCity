package city.transportation.mock;

/**
 * This is the base class for all mocks.
 *
 * @author Sean Turner
 *
 */
public class Mock {
	private String name;

	public Mock(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}

	public String toString() {
		return this.getClass().getName() + ": " + name;
	}

}
