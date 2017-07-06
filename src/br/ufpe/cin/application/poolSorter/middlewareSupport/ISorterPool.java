package br.ufpe.cin.application.poolSorter.middlewareSupport;

import java.util.ArrayList;

/**
 * Created by Ricardo on 06/07/2017.
 */
public interface ISorterPool {
    ArrayList<Integer> sort(ArrayList<Integer> list) throws Exception;
}
