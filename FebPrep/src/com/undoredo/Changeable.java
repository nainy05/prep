package com.undoredo;


/**
 * Interface to implement a Changeable type of action - either undo or redo.
 */

public interface Changeable {

	/**
	 * Undoes an action
	 */
	public void undo();

	/**
	 * Redoes an action
	 */

	public void redo();

}
