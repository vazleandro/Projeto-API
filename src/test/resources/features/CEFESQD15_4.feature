# language: pt
@piloto
Funcionalidade: Criacao de um de controle de piloto atraves do SEVEN
  Como um Gestor
  Eu preciso possuir o controle do piloto atraves de parametrizacao do SEVEN
  Para que eu possa ligar ou desligar o piloto

  Contexto: 
    Dado que o usuario informe o nome da transacao a ser executado
    E informe sua racf e senha
    E informe a comunicacao "PJTCPIMS"

  Esquema do Cenario: Realizar a validacao do Indicador de Piloto com base nos parametros
    Dado que eu informe o passo a ser executado "<passo>"
    Quando utilizar os parametros Agencia "<agencia>" Conta "<conta>" Dac "<dac10>" produto "<produto>" segmento "<segmento>" canal "<canal>"
    E realizar a consulta ao Seven
    Entao a resposta tera a seguinte mensagem "<mensagem>" para o cenario "<cenario>"

    Exemplos: 
      | passo | agencia | conta   | dac10 | produto   | segmento | canal | mensagem                                                                      | cenario   |
      |    01 |    1500 | 0001010 |     1 | 000000083 | L        |    11 | PILOTO: S - RC: 00 - PROCESSAMENTO EFETUADO COM SUCESSO                       | Piloto_1  |
      |    01 |    1500 | 0001010 |     1 | 000000083 |        4 |    11 | PILOTO: N - RC: 00 - PROCESSAMENTO EFETUADO COM SUCESSO                       | Piloto_2  |
      |    01 |    1500 | 0001010 |     1 | 000000083 |        3 |    11 | PILOTO: S - RC: 00 - PROCESSAMENTO EFETUADO COM SUCESSO                       | Piloto_3  |
      |    01 |    1000 | 0001010 |     1 | 000000083 |        3 |    11 | PILOTO: S - RC: 00 - PROCESSAMENTO EFETUADO COM SUCESSO                       | Piloto_4  |
      |    01 |    1000 | 0001010 |     1 | 000000083 | L        |    11 | PILOTO: S - RC: 00 - PROCESSAMENTO EFETUADO COM SUCESSO                       | Piloto_5  |
      |    01 |    1000 | 0001010 |     1 | 000000083 |        4 |    11 | PILOTO: S - RC: 00 - PROCESSAMENTO EFETUADO COM SUCESSO                       | Piloto_6  |
      |    01 |    1234 | 0001010 |     1 | 000000083 |        4 |    11 | PILOTO: N - RC: 00 - PROCESSAMENTO EFETUADO COM SUCESSO                       | Piloto_7  |
      |    01 |    1234 | 0001010 |     1 | 000000083 |        3 |    11 | PILOTO: N - RC: 00 - PROCESSAMENTO EFETUADO COM SUCESSO                       | Piloto_8  |
      |    01 |    1234 | 0001010 |     1 | 000000083 | L        |    11 | PILOTO: N - RC: 00 - PROCESSAMENTO EFETUADO COM SUCESSO                       | Piloto_9  |
      |    01 |    0000 | 0001010 |     1 | 000000083 | L        |    11 | PILOTO:   - RC: 02 - AGENCIA DEVE SER NUMERICO E DIFERENTE DE ZEROS           | Piloto_10 |
      |    01 |         | 0001010 |     1 | 000000083 | L        |    11 | PILOTO:   - RC: 01 - CAMPO PREENCHIDO INCORRETAMENTE - AGENCIA                | Piloto_11 |
      |    01 | AAAA    | 0001010 |     1 | 000000083 | L        |    11 | PILOTO:   - RC: 02 - AGENCIA DEVE SER NUMERICO E DIFERENTE DE ZEROS           | Piloto_12 |
      |    01 |    1500 | 0000000 |     1 | 000000083 | L        |    11 | PILOTO:   - RC: 04 - CONTA DEVE SER NUMERICO E DIFERENTE DE ZEROS             | Piloto_13 |
      |    01 |    1500 |         |     1 | 000000083 | L        |    11 | PILOTO:   - RC: 03 - CAMPO PREENCHIDO INCORRETAMENTE - CONTA                  | Piloto_14 |
      |    01 |    1500 | ZZZZZZZ |     1 | 000000083 | L        |    11 | PILOTO:   - RC: 04 - CONTA DEVE SER NUMERICO E DIFERENTE DE ZEROS             | Piloto_15 |
      |    01 |    1500 | 0001010 |     1 | 000000083 |          |    11 | PILOTO:   - RC: 07 - SEGMENTO DEVE SER DIFERENTE DE ESPACOS                   | Piloto_16 |
      |    01 |    1500 | 0001010 |     1 | 000000000 |        3 |    11 | PILOTO:   - RC: 06 - CODIGO DO PRODUTO DEVE SER NUMERICO E DIFERENTE DE ZEROS | Piloto_17 |
      |    01 |    1500 | 0001010 |     1 | ZZZZZZZZZ |        3 |    11 | PILOTO:   - RC: 06 - CODIGO DO PRODUTO DEVE SER NUMERICO E DIFERENTE DE ZEROS | Piloto_18 |
      |    01 |    1500 | 0001010 |     1 |           |        3 |    11 | PILOTO:   - RC: 06 - CODIGO DO PRODUTO DEVE SER NUMERICO E DIFERENTE DE ZEROS | Piloto_19 |
      |    01 |    1500 | 0001010 |       | 000000083 |        3 |    11 | PILOTO:   - RC: 05 - DAC DEVE SER NUMERICO                                    | Piloto_20 |
      |    01 |    1500 | 0001010 | Z     | 000000083 |        3 |    11 | PILOTO:   - RC: 05 - DAC DEVE SER NUMERICO                                    | Piloto_21 |
      |    01 |    1500 | 0001010 |     1 | 000000083 |        3 |    00 | PILOTO:   - RC: 07 - CANAL DEVE SER NUMERICO E DIFERENTE DE ZEROS             | Piloto_22 |
      |    01 |    1500 | 0001010 |     1 | 000000083 |        3 | AA    | PILOTO:   - RC: 07 - CANAL DEVE SER NUMERICO E DIFERENTE DE ZEROS             | Piloto_23 |
