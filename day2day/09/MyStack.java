Stack<Character> cStack;  // wordStack
Stack<String> sStack;  // sentenceStack

// Constructor(s)
public Words() {
	cStack = new Stack<Character>();
	sStack = new Stack<String>();
}

// @param type 0 instantiates a Char stack for a word,
// 1 a String stack for a sentence
public Words(int type) {
	if (type==0)
		cStack = new Stack<Character>();
	else
		sStack = new Stack<String>();
}

public void push(Character c) {
	cStack.push(c);
}

public char pop() {
	return cStack.pop();
}

public char peek() {
	return cStack.peek();
}

public boolean empty() {
	return cStack.empty();
}

// Empties the stack
public void emptyStack() {
	cStack = new Stack<Character>();
}
