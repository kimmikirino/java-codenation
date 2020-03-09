package br.com.curso.relatorios;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class GerarRelatorio {

    public void gerarRelatorio(List<Object> list, int qtdColunas) {
        gerarTitulos(list, qtdColunas);
        gerarLinhas(list, qtdColunas);
    }

    private void gerarTitulos(List<Object> list, int qtdColunas) {
        for(int i = 1; i <= qtdColunas; i++) {
            System.out.print(getMetodoPorOrdem(list.get(0).getClass(), i).getAnnotation(Coluna.class).titulo());
            if(i < qtdColunas) {
                System.out.print(", ");
            }
        }
        System.out.print("\n");

    }

    private void gerarLinhas(List<Object> list, int qtdColunas) {
        for (Object object : list) {
            for (int i = 1; i <= qtdColunas; i++) {
                try {
                    System.out.print(getMetodoPorOrdem(object.getClass(), i).invoke(object));
                    if(i < qtdColunas){
                        System.out.print(", ");
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("\n");
        }
    }

    private Method getMetodoPorOrdem(Class tipo, int ordem) {
        Method[] metodos = tipo.getMethods();

        for(Method metodo: metodos) {
            if(metodo.getDeclaredAnnotation(Coluna.class) != null
                    && metodo.getDeclaredAnnotation(Coluna.class).posicao() == ordem){
                return metodo;
            }
        }
        return null;
    }
}
