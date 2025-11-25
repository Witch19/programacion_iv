void main(){
    print("maps iterables");
    final numbers = [1,2,3,4,5,6,7,8,9,10];
    print("Lista original: $numbers");
    print("Tamano ${numbers.length}");
    print("Indice 4 ${numbers[4]}");
    print("primer elemento ${numbers.first}");
    print("Reverso de numeros ${numbers.reversed}");

    final reversedNumbers = numbers.reversed;
    print("Reverso de numbers ${reversedNumbers}");
    print("List: ${reversedNumbers.toList()}");
    print("Set: ${reversedNumbers.toSet()}");
}