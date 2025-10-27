import datetime, xmlrpc.client
from xmlrpc.server import SimpleXMLRPCServer

def hoje_eh():
	hoje = datetime.datetime.today()
	return xmlrpc.client.DateTime(hoje)


def gera_email(nome):
	email_gerado = nome + "@ufn.edu.br"
	return email_gerado


def retira_strings(frase):
	artigos_definidos = ["o", "a", "os", "as"]

	artigos_indefinidos = ["um", "uma", "uns", "umas"]

	artigos = artigos_definidos + artigos_indefinidos

	palavras = frase.split()

	palavrs_sem_artigos = (p for p in palavras if p.lower() not in artigos)

	frase_sem_artigos = " ".join(palavrs_sem_artigos)
	return frase_sem_artigos


servidor = SimpleXMLRPCServer(("localhost", 4000))
print("Ouvindo a porta 4000...")
servidor.register_function(hoje_eh, "hoje")
servidor.register_function(gera_email, "email_gerado")
servidor.register_function(retira_strings, "frase_sem_artigos")
servidor.serve_forever()