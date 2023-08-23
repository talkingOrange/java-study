package prob5;

import java.util.Arrays;

public class MyStack {
	private String[] buffer;
	private int bufferSize;
	private int top;

	public MyStack() {
	}

	public MyStack(int bufferSize) {
		super();
		this.top = 0;
		this.bufferSize = bufferSize;
		this.buffer = new String[bufferSize];
	}

	public MyStack(String[] buffer, int bufferSize) {
		super();
		this.buffer = buffer;
		this.bufferSize = bufferSize;

	}

	public String[] getBuffer() {
		return buffer;
	}

	public void setBuffer(String[] buffer) {
		this.buffer = buffer;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	@Override
	public String toString() {
		return "MyStack [buffer=" + Arrays.toString(buffer) + ", bufferSize=" + bufferSize + "]" + top;
	}

	public void push(String string) {
		if (top == buffer.length) {
			bufferSizeUp();
		}

		buffer[top] = string;
		top++;
	}

	public void bufferSizeUp() {
		int newBufferSize = buffer.length * 2;
		String[] bigBuffer = new String[newBufferSize];

		for (int i = 0; i < buffer.length; i++) {
			bigBuffer[i] = buffer[i];
		}

		buffer = bigBuffer;
	}

	public boolean isEmpty() {
		if (top == 0) {
			return true;
		}
		return false;
	}

	public String pop() throws MyStackException {
		if( top == 0) {
			throw new MyStackException();
		}
		top--;
		return buffer[top];
		
	}

	// 스택 사이즈 알아서 늘리기
	// isEmpty - top에 따라 확인 가능

}