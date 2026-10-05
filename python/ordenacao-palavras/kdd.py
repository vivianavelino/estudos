import time

palavras = list()

with open("texto.txt", "r", encoding="utf-8") as arquivo:
    for linha in arquivo:
        palavras_da_linha = linha.split()

        for palavra in palavras_da_linha:
            palavras.append(palavra)

inicio = time.time()

palavras.sort()

fim = time.time()

tempo = fim - inicio

print("PALAVRAS ORDENADAS")
print(palavras)

print()

print("Tempo de execução:")
print(tempo)

with open("palavras_ordenadas.txt", "w", encoding="utf-8") as arquivo:
    for palavra in palavras:
        arquivo.write(palavra + "\n")

print()
print("Arquivo palavras_ordenadas.txt criado com sucesso!")
