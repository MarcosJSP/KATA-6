package kata.pkg6;

import java.io.File;
import java.util.Iterator;

public class KATA6 {
    public static void main(String[] args) {
        File root = new File("/");
        File[] files = root.listFiles();
        Histogram histo;
        
        histo = new Histogram<>(lengths(iteratorOf(files))) ;
        System.out.println("Contenido [b,nfiles]: "+histo.getMap().entrySet());
        
        histo = new Histogram<>(megaBytes(lengths(iteratorOf(files))));
        System.out.println("Contenido [mb,nfiles]: "+histo.getMap().entrySet());
    }
    
    private static <T> Iterator<T> iteratorOf (T[] items){
        return new Iterator<T>() {
            int index = 0;
            
            @Override
            public boolean hasNext() {
                return index < items.length;
            }

            @Override
            public T next() {
                return items[index++];
            }
        };
    }

    private static Iterator<Long> lengths(Iterator<File> iterator) {
        return new Iterator<Long>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Long next() {
                return iterator.next().length();
            }
        };
    }

    private static Iterator<Integer> megaBytes(Iterator<Long> iterator) {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return (int) (iterator.next()/(1024*1024));
            }
        };
    }
    
    
    
}
