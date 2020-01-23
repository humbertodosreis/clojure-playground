(ns curso.ariedade)
;; Definimos uma coleção de clientes
(def clientes [
               {:nome "Humberto" :cpf "33344455599" :data-nascimento "11/01/1984"}
               {:nome "Fernanda" :cpf "22233311100" :data-nascimento "16/09/1983"}
               ])

;; impressão de cada cliente da coleção
(map println clientes)

;; Queremos imprimir os dados formatado
(defn imprime-formatado [cliente]
  (println
    "NOME:" (:nome cliente)
    ",CPF: " (:cpf cliente)
    ",DT. NASCIMENTO" (:dt-nascimento cliente)))

;; exemplo com destruction
(defn imprime-formatado
  [{nome :nome cpf :cpf dt-nascimento :dt-nascimento}]
  (println
    "NOME:" nome
    ",CPF: " cpf
    ",DT. NASCIMENTO" dt-nascimento))

;; imprime usando a nossa função
(map imprime-formatado clientes)

;; definimos uma outra função para imprimir ofuscado
(defn imprime-ofuscado
  [{nome :nome}]
  (println "NOME:" nome ",CPF: ***, DT-NASC: ***"))

(map imprime-ofuscado clientes)

;; vamos colocar os nossos mapas em funcoes
(defn imprime-clientes-formatado [clientes]
  (map imprime-formatado clientes))

(defn imprime-clientes-ofuscado [clientes]
  (map imprime-ofuscado clientes))

(imprime-clientes-formatado clientes)
(imprime-clientes-ofuscado clientes)

;; quero que as funcoes exibe-clientes-formatado e ofuscado sejam uma só
(defn imprime-clientes [colecao ofuscado?]
  (if ofuscado? (map imprime-ofuscado clientes)
                (map imprime-formatado clientes)))

(imprime-clientes clientes false)
(imprime-clientes clientes true)

;; quando a exibição for o formato padrão,
;; não quero ter que passar um terceiro argumento
;; uma alternativa seria criar uma função que chama exibe-clientes passado false
(defn imprime-clientes-padrao [colecao]
  (imprime-clientes colecao false))

(imprime-clientes-padrao clientes)

;; Uma alternativa melhor é a sobrecarga de aridade
;; aridade está relacionada a quantidade de argumento de uma função
;; map, por exemplo, tem aridade 2 (recebe dois argumentos)
(defn exemplo-aridade
  ([] "Funcao com aridade zero")
  ([arg1] "Funcao com aridade 1")
  ([arg1 arg2] "Aridade 2"))

(exemplo-aridade)
(exemplo-aridade 1)
(exemplo-aridade 1 2)

;; Então, vamos alterar a nossa função
(defn imprime-clientes
  ;; quando recebe dois argumentos
  ([colecao ofuscado?]
   (if ofuscado? (map imprime-ofuscado colecao)
                 (map imprime-formatado colecao)))

  ;; quando recebe um argumento
  ([colecao] (imprime-clientes colecao false)))

(imprime-clientes clientes)
(imprime-clientes clientes true)

;; se sobrar tempo
;; a função imprime pode recebe o formatador como um argumento
(defn imprime-clientes
  ;; quando recebe dois argumentos
  ([colecao formatador] (map formatador colecao))

  ;; quando recebe um argumento
  ([colecao] (imprime-clientes colecao imprime-formatado)))

(imprime-clientes clientes)
(imprime-clientes clientes imprime-ofuscado)