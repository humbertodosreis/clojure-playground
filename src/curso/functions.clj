(ns curso.functions)

; revisar def
; explicar defn sem parametro
; explicar defn com parametro (revisar concatenação de string)
; explicar defn com mais de uma instrução


; Revisão de definição de simbolo
(def nome "Dadinho")
(println nome)

(def nome "Zé Pequeno")
(println nome)

; definir uma função
(defn diga-ola [] (println "Ola"))
(diga-ola)

(defn diga-meu-nome [nome]
  (println "Seu nome é", nome, "!" ))

; Relembra que a função vem primeiro
(diga-meu-nome nome)

; Executar mais de uma instrução
(defn diga-meu-nome [nome]
  (println "Oi")
  (println "Seu nome é", nome, "!" ))

(diga-meu-nome nome)

(defn devolve-numero [] (15))
(println devolve-numero)

; Agora queremos criar uma função que retorne o valor total do pedido
; imperativa
; montar junto com os alunos
(defn total-calculado [numero-itens valor-unitario]
  (* numero-itens valor-unitario))

; comentar conceito de função pura, sempre que eu chamo, sempre devolvera o mesmo valor
(total-calculado 10 5)

