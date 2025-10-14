void main(){
    print("Tipos de variables en dart");
    final String pokemon ="Ditto";
    //pokemon="ute";
    print(pokemon);

    String myName = "Joss";
    myName="Saavedra";
    print(myName);

    const String elemento ="Fuego";
    print("elemento: $elemento");

    bool active = false;
    print("activar: $active");

    int hp = 100;
    print("caballos de fuego $hp");

    List<string> habilidades =["impostor","correlon"];
    print("habilidades: $habilidades");

    final sprites = <String>["src/imagen1.jpg","imagen2.jpg"];
    print("Imagenes: $sprites");

    print("Impresion en varias linesas");
    print("""
    $pokemon
    $hp
    $sprites
    $habilidades
    """);

}