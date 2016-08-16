package home.tenth.src.main.java;

@FunctionalInterface
interface Converter<F, T>{
    T convert(F f);
}