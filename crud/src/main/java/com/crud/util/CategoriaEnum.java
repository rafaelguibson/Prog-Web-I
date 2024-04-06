public enum CategoriaEnum {
    CAFE_DA_MANHA(1, "Café da Manhã"),
    ALMOCO(2, "Almoço"),
    JANTAR(3, "Jantar"),
    LANCHE(4, "Lanche"),
    SOBREMESA(5, "Sobremesa"),
    DRINKS(6, "Drinks");

    private final int codigo;
    private final String descricao;

    CategoriaEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CategoriaEnum getByCodigo(int codigo) {
        for (CategoriaEnum categoria : CategoriaEnum.values()) {
            if (categoria.getCodigo() == codigo) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Código de categoria inválido: " + codigo);
    }
}
