from openpyxl import Workbook
import requests
import json
import re

#variaveis
IDs = []
Produtos = []
Preco = []
# Pegar os IDs - Retorna a lista IDs:


def getlistaids():
    global IDs
    try:
        for i in range(0, 10):
            url = "https://api.gpa.digital/pa/products/list/secoes/C4215/cervejas?storeId=501&qt=12&s=&ftr=facetSubShelf_ss%3A4215_Cervejas&p=" + \
                str(i)
            pagina = requests.get(url).text
            for x in range(0, 12):
                IDs.append(
                    int(json.loads(pagina)["content"]["products"][x]["id"]))
    except IndexError:
        None

    # Cervejas Especiais

    try:
        for i in range(0, 10):
            url = "https://api.gpa.digital/pa/products/list/secoes/C4215/cervejas-especiais?storeId=501&qt=12&s=&ftr=facetSubShelf_ss%3A4215_Cervejas__facetSubShelf_ss%3A4215_Cervejas%20Especiais&p=" + \
                str(i)
            pagina = requests.get(url).text
            for x in range(0, 12):
                IDs.append(
                    int(json.loads(pagina)["content"]["products"][x]["id"]))
    except IndexError:
        None
    print("IDs importados com sucesso!")
    return


def getdetails(listaids):
    global Produtos
    global Preco
    p = 0
    for ids in listaids:
        url = "https://api.gpa.digital/pa/products/" + \
            str(ids) + "?storeId=501&isClienteMais=false"
        Produtos.append(json.loads(requests.get(url).text)["content"]["name"])
        p = round(float(json.loads(requests.get(url).text)
                        ["content"]["currentPrice"]), 2)
        if p == 0:
            p = "Indisponível"
        Preco.append(p)
    return


def joganaplan():
    wb = Workbook()
    ws = wb.active
    ws.append(["IDs", "Produtos", "Preço"])
    for i in range(0, len(IDs)):
        ws.append([IDs[i], Produtos[i], Preco[i]])
    wb.save("Brejas.xlsx")
    print("Salvo em Excel!")
    return


getlistaids()

getdetails(IDs)

joganaplan()
