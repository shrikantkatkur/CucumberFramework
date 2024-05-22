package Exceptions;

public class InvalidBrowserNameError extends Error {
		 private String msg;
			public InvalidBrowserNameError(String browserName) {
				msg=("Invalid Browser Name:"+browserName);
				}
			@Override
			public String toString() {
			return msg;
			}

		
		}


