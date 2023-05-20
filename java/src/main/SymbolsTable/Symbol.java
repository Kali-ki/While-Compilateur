package SymbolsTable;

public class Symbol<T>{

    private String name;
    private T value;
    
    
    public Symbol(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj == null){
            return false;
        }

        if(obj.getClass() != this.getClass()){
            return false;
        }

        @SuppressWarnings("unchecked")
        Symbol<T> symbol_compared = (Symbol<T>) obj;

        if(!this.name.equals(symbol_compared.getName())){
            return false;
        }

        return true;

    }

}


