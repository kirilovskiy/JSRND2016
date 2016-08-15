package home.tenth.src.main.java;

@FunctionalInterface
interface mergeLists<T1, T2> {
    T1 mergeList(T1 t1, T2 t2);
}