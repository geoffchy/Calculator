//Exception class when not an integer
package cs2s03;

@SuppressWarnings("serial")
class NotAnInteger extends Throwable {
    @SuppressWarnings("unused")
	private String kind;

    public NotAnInteger(String s) { this.kind = s; }

}
