import datetime, xmlrpc.client
from xmlrpc.server import SimpleXMLRPCServer

def hoje_eh():
	hoje = datetime.datetime.today()
	return xmlrpc.client.DateTime(hoje)


def gera_email(nome):
	email_gerado = nome + "@ufn.edu.br"
	return email_gerado


servidor = SimpleXMLRPCServer(("localhost", 8000))
print("Ouvindo a porta 8000...")
servidor.register_function(hoje_eh, "hoje")
servidor.register_function(gera_email, "email_gerado")
servidor.serve_forever()