package programtestrunner;

import java.io.Serializable;

public class BillPughSingleton implements Cloneable ,Serializable{
		private static final long serialVersionUID = 1L;
		private BillPughSingleton() {}

	    private static class SingletonHelper {
	        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	    }

	    public static BillPughSingleton getInstance() {
	        return SingletonHelper.INSTANCE;
	    }
	    @Override
	    protected Object clone() throws CloneNotSupportedException {
	        throw new CloneNotSupportedException();
	    }
	    protected Object readResolve() {
	        return getInstance();
	    }
	}


