package by.den.spring.javaConfig;

public class Course {

	private Module module;
    private String name;
	
	public Course() {
	}
	
	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setup() {
		this.name = "M100 Pythagoras Theorems";
	}

	public void cleanup() {
		module = null;
	}
}