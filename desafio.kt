// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel {BASICO, INTERMEDIARIO, AVANCADO}

data class Usuario(val nome: String, val matricula: String) {
    override fun toString(): String {
        return "$nome (Matrícula: $matricula)"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    override fun toString(): String {
        return "$nome (Duração: $duracao minutos)"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }

    override fun toString(): String {
        val retorno = "Curso: $nome\nMatérias: $conteudos\nNível: $nivel\nAlunos: $inscritos"
        return retorno
    }
}

//  Deverá existir uma estrutura na base de dados com a última matricula utilizada.
var ultimaMatricula: Int = 0

fun getMatricula(): String {
    ultimaMatricula = ultimaMatricula + 1
    return ultimaMatricula.toString()
}

fun main() {
    //  TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //  TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    // Cria alunos para teste (botar a familia toda para estudar)
    val usuario1 = Usuario("João", getMatricula())
    val usuario2 = Usuario("Maria", getMatricula())
    val usuario3 = Usuario("José", getMatricula())
    val usuario4 = Usuario("Washington", getMatricula())
    val usuario5 = Usuario("Welton", getMatricula())
    val usuario6 = Usuario("Vanessa", getMatricula())
    val usuario7 = Usuario("Bruno", getMatricula())
    val usuario8 = Usuario("Caio", getMatricula())
    val usuario9 = Usuario("Vinicius", getMatricula())

    // Cria formações
    val conteudoEducacional1 = ConteudoEducacional("Lógica de Programação", 120)
    val conteudoEducacional2 = ConteudoEducacional("Fluxograma", 80)
    val conteudoEducacional3 = ConteudoEducacional("Banco de dados")
    val conteudoEducacional4 = ConteudoEducacional("Redes", 150)

    // Cria formações
    val formacao1 = Formacao("Cobol", listOf(conteudoEducacional1, 
                                               conteudoEducacional2, 
                                               conteudoEducacional3), Nivel.AVANCADO)    
    val formacao2 = Formacao("ePortal (Unisys)", listOf(conteudoEducacional1, 
                                			   conteudoEducacional2, 
                                               conteudoEducacional3), Nivel.INTERMEDIARIO)
    val formacao3 = Formacao("Redes Básico", listOf(conteudoEducacional4), Nivel.BASICO)
    
    // Matricula os alunos 
    formacao1.matricular(usuario1,usuario3,usuario5,usuario6,usuario9)
    formacao2.matricular(usuario2,usuario4,usuario6,usuario7)
    formacao3.matricular(usuario6,usuario8)

    // Exibe as informações
    println(formacao1)
    println("\n\n")
    println(formacao2)
    println("\n\n")
    println(formacao3)
    println("\n\n")

}
