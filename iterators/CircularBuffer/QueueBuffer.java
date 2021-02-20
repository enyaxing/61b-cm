import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueueBuffer<T> implements Iterable<T>
{

    List<T> content;
    long modTimeStamp;

    public QueueBuffer()
    {
        modTimeStamp = 0;
        content = new ArrayList<>();
    }

    public void add(T item)
    {
        modTimeStamp++;
        content.add(item);
    }

    public T pop(T item)
    {
        modTimeStamp++;
        return content.remove(0);
    }

    @Override
    public Iterator<T> iterator()
    {
        return new CircularIterator();
    }

    public class CircularIterator implements Iterator<T>
    {
        int index;
        long initTimeStamp;

        private void checkMod()
        {
            if (initTimeStamp != modTimeStamp)
                throw new RuntimeException("Iterating a modified CircularBuffer");
        }

        @Override
        public boolean hasNext()
        {
            checkMod();
            return content.size() > 0;
        }

        @Override
        public T next()
        {
            checkMod();
            T value = content.get(index);
            index = (index + 1) % content.size();
            return value;
        }
    }
}
