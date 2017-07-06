package br.ufpe.cin.application.poolSorter.middlewareSupport;

import br.ufpe.cin.cryptoom.distribution.invocation.AOR;
import br.ufpe.cin.cryptoom.distribution.invocation.Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Ricardo on 06/07/2017.
 */
public class SorterPoolImpl extends Base implements ISorterPool {
    private List<Sorter> pool;

    private class Sorter {
        ReentrantLock lock;
        int id;

        Sorter(int id) {
            this.id = id;
            lock = new ReentrantLock();
        }

        ArrayList<Integer> sort(ArrayList<Integer> list) {
            System.out.println("Sorter id: " + this.id);
            Collections.sort(list);
            lock.unlock();

            return list;
        }
    }

    public SorterPoolImpl(AOR aor) {
        super(aor);
        pool = IntStream.range(0, 10).mapToObj(index -> new Sorter(index)).collect(Collectors.toList());
    }

    @Override
    public String getIdentifier() {
        return "SorterPool";
    }

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> list) throws Exception {
        Sorter s = pool.stream()
                .filter(sorter -> sorter.lock.tryLock())
                .findFirst()
                .orElseThrow(() -> new Exception("Cannot find a Sorter."));

        return s.sort(list);
    }
}
