package so.chaos.transfer.utils.impl;

import java.io.Serializable;

import so.chaos.transfer.utils.api.Range;

public class Ranges implements  Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final class InnerRange implements Range {

		private static final long serialVersionUID = 1L;
		private final int start;
		private final int length;
		
		private InnerRange(int start, int length) {
			this.start = start;
			this.length = length;
		}
		
		@Override
		public int getStart() {
			return start;
		}

		@Override
		public int getLength() {
			return length;
		}
		
	}
	
	private static class Builder implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		private int start;
		private int length;
		
		public Builder setStart(int start) {
			this.start = start;
			return this;
		}
		public Builder setLength(int length) {
			this.length = length;
			return this;
		}
		
		public Range range() {
			return new Ranges.InnerRange(this.start, this.length);
		}
		
		
	}
	
	public static final Range valueOfStartAndLength(int start, int length) {
		
		return new Ranges.InnerRange(start, length);
	}
	
	public static final Ranges.Builder newBuilder() {
		
		return new Ranges.Builder();
	}
	
	public static void main(String[] args) {
		
		Builder builder = newBuilder()
				.setStart(0)
				.setLength(10);
		
		for (int i = 0; i < 10; i++) {
			builder.setStart(i);
			Range range1 = builder.range();
			System.out.println(range1.getStart() + " :" + range1.getLength());
		}
		
		Range range2 = Ranges.valueOfStartAndLength(20, 10);
		System.out.println(range2.getStart());
		System.out.println(range2.getLength());
		
		
		
	}
}
