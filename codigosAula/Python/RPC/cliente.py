import xmlrpc.client, datetime

servidor = xmlrpc.client.ServerProxy("http://10.103.16.19:8000/")

hoje = servidor.hoje()
nome = "Eduardo"
email = servidor.gerar_email(nome)
frase = "os carasa sao umas pessoas bem legais"
frase_devolvida = servidor.retirar_artigos(frase)

# convert the ISO8601 string to a datetime object
data_hora_convertida = datetime.datetime.strptime(hoje.value, "%Y%m%dT%H:%M:%S")
print("Hoje é: %s" % data_hora_convertida.strftime("%d.%m.%Y, %H:%M:%S"))
print(f"Email: {email}")
print(f"Frase: {frase_devolvida}")