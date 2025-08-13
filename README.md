# SistemasDistribuidos

// Pinos
int pinI = 2; // Entrada I
int pinM = 3; // Entrada M
int pinC = 4; // Entrada C
int pinAlarme = 13; // Saída (LED ou buzzer)

void setup() {
  pinMode(pinI, INPUT);
  pinMode(pinM, INPUT);
  pinMode(pinC, INPUT);
  
  pinMode(pinAlarme, OUTPUT);
}

void loop() {
  // Ler entradas
  bool I = digitalRead(pinI);
  bool M = digitalRead(pinM);
  bool C = digitalRead(pinC);

  // Implementar lógica das portas (sem simplificação)    
  bool and2 = M && (!C);    // AND do meio
  bool and3 = I && (!C);    // AND superior
  bool and1 = (!I) && M;    // AND inferior

  bool saida = and1 || and2 || and3; // OR final

  // Aciona saída
  digitalWrite(pinAlarme, saida ? HIGH : LOW);
}
