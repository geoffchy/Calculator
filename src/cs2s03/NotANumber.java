//Exception class for when not a number ie string/character/infinity
package cs2s03;

@SuppressWarnings("serial")
class NotANumber extends Throwable {
    @SuppressWarnings("unused")
	private String kind;

    public NotANumber(String s) { this.kind = s; }

}
