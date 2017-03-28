package io.github.volyx;

import org.rocksdb.RocksDB;
import org.rocksdb.Options;
import org.rocksdb.*;

public class Main {

	public static void main(String[] args) {

			 // a static method that loads the RocksDB C++ library.
			  RocksDB.loadLibrary();
			  // the Options class contains a set of configurable DB options
			  // that determines the behavior of a database.
			  Options options = new Options().setCreateIfMissing(true);
			  RocksDB db = null;
			  try {
			    // a factory method that returns a RocksDB instance
			    db = RocksDB.open(options, "C:\\Users\\dima.v\\private\\spring4-mvc-gradle-annotation-hello-world\\src\\main\\resources\\db");
			    // do something
			  } catch (RocksDBException e) {
			    // do some error handling
			    // ...
			  }

		  	byte[] key1 = "key1".getBytes();
			byte[] key2 = "key2".getBytes();
			// some initialization for key1 and key2
			try {
			  byte[] value = db.get(key1);
			  if (value != null) {  // value == null if key1 does not exist in db.
			    db.put(key2, value);
			  }
			  db.remove(key1);
			} catch (RocksDBException e) {
			  // error handling
			}

		  System.out.println("Inserted");
		
	}
}