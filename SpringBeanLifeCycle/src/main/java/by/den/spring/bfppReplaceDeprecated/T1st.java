package by.den.spring.bfppReplaceDeprecated;

@DeprecatedClass(replacedBy = T1000.class)
public class T1st implements Robot {

    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void sayBye() {
        System.out.println("msg="+msg);
        System.out.println("Я 1й каркас");
    }
}
