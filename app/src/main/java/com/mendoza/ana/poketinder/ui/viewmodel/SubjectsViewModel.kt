package com.mendoza.ana.poketinder.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import com.mendoza.ana.poketinder.R
import com.mendoza.ana.poketinder.ui.model.Subject
import com.mendoza.ana.poketinder.ui.model.Topic


class SubjectsViewModel : ViewModel() {
    private val _filter = MutableLiveData<String>()
    private val _subjects = MutableLiveData<List<Subject>>(mutableListOf(
        Subject(
            title = "Álgebra",
            description = "Conceptos fundamentales y fórmulas esenciales en álgebra.",
            amount = "40 temas",
            topics = listOf(
                Topic(
                    title = "Polinomios",
                    definition = "Un polinomio es una expresión algebraica compuesta por una suma de términos, cada uno formado por el producto de constantes y variables con exponentes no negativos.",
                    terms = """
                        • Términos: Partes del polinomio separadas por signos de suma o resta.
                        • Coeficientes: Números que multiplican a las variables.
                        • Variables: Letras que representan valores desconocidos (x, y, z, etc.).
                        • Exponentes: Indican cuántas veces se multiplica la variable por sí misma.
                        • Grado: El mayor exponente presente en el polinomio.
                        • Monomio: Polinomio con un solo término.
                        • Binomio: Polinomio con dos términos.
                        • Trinomio: Polinomio con tres términos.
                        • Término independiente: Término sin variable.
                    """.trimIndent(),
                    description = """
                        Forma general:
                        P(x) = aₙxⁿ + aₙ₋₁xⁿ⁻¹ + ... + a₁x + a₀

                        Ejemplo:
                        Para P(x) = 2x² + 3x + 1, evaluar P(1):
                        P(1) = 2(1)² + 3(1) + 1 = 2 + 3 + 1 = 6

                        Operaciones con polinomios:
                        • Suma y resta: Se agrupan términos semejantes.
                        • Multiplicación: Se aplica la propiedad distributiva.
                        • División: Se utiliza la división sintética o el método de Ruffini.

                        Teorema del factor:
                        Si P(a) = 0, entonces (x - a) es un factor de P(x).
                    """.trimIndent()
                ),
                Topic(
                    title = "Ecuaciones Cuadráticas",
                    definition = "Una ecuación cuadrática es una ecuación polinómica de segundo grado, es decir, una ecuación que contiene un término con la variable al cuadrado como su término de mayor grado.",
                    terms = """
                        • Discriminante: b² - 4ac
                        • Raíces: Soluciones de la ecuación
                        • Vértice: Punto máximo o mínimo de la parábola
                        • Eje de simetría: Línea vertical que pasa por el vértice
                        • Factorización: Expresar la ecuación como producto de factores lineales
                    """.trimIndent(),
                    description = """
                        Forma estándar:
                        ax² + bx + c = 0, donde a ≠ 0

                        Fórmula cuadrática:
                        x = [-b ± √(b² - 4ac)] / (2a)

                        Ejemplo:
                        Resolver x² - 3x + 2 = 0
                        
                        Método 1 (Factorización):
                        (x - 1)(x - 2) = 0
                        x = 1 o x = 2

                        Método 2 (Fórmula cuadrática):
                        a = 1, b = -3, c = 2
                        x = [3 ± √((-3)² - 4(1)(2))] / (2(1))
                        x = (3 ± √1) / 2
                        x = (3 + 1) / 2 = 2 o x = (3 - 1) / 2 = 1

                        Propiedades de las raíces:
                        • Suma de las raíces: x₁ + x₂ = -b/a
                        • Producto de las raíces: x₁ · x₂ = c/a
                    """.trimIndent()
                ),
                Topic(
                    title = "Funciones",
                    definition = "Una función es una relación entre dos conjuntos, donde a cada elemento del conjunto de entrada (dominio) le corresponde un único elemento del conjunto de salida (codominio).",
                    terms = """
                        • Dominio: Conjunto de valores de entrada
                        • Codominio: Conjunto de todos los posibles valores de salida
                        • Rango: Conjunto de valores de salida realmente alcanzados
                        • Función inyectiva: Cada elemento del codominio corresponde a lo sumo a un elemento del dominio
                        • Función sobreyectiva: Cada elemento del codominio corresponde al menos a un elemento del dominio
                        • Función biyectiva: Función que es tanto inyectiva como sobreyectiva
                    """.trimIndent(),
                    description = """
                        Notación:
                        f: X → Y
                        y = f(x)

                        Ejemplos de funciones:
                        1. Función lineal: f(x) = mx + b
                        2. Función cuadrática: f(x) = ax² + bx + c
                        3. Función exponencial: f(x) = aˣ
                        4. Función logarítmica: f(x) = log_a(x)

                        Composición de funciones:
                        (f ∘ g)(x) = f(g(x))

                        Función inversa:
                        Si f(a) = b, entonces f⁻¹(b) = a
                    """.trimIndent()
                )
            ),
            imageUrl = R.drawable.algebra,
            isFavorite = false
        ),
        Subject(
            title = "Cálculo",
            description = "Conceptos fundamentales y avanzados del cálculo diferencial e integral.",
            amount = "35 temas",
            topics = listOf(
                Topic(
                    title = "Límites",
                    definition = "Un límite describe el comportamiento de una función a medida que su variable independiente se acerca a un valor específico o al infinito.",
                    terms = """
                • Límite
                • Convergencia
                • Divergencia
                • Límite lateral
                • Límite al infinito
                • Asíntota (vertical, horizontal, oblicua)
                • Continuidad
                • Teorema del Sándwich
            """.trimIndent(),
                    description = """
                Notación formal:
                lim(x→c) f(x) = L

                Propiedades de los límites:
                1. lim(x→c) [f(x) ± g(x)] = lim(x→c) f(x) ± lim(x→c) g(x)
                2. lim(x→c) [f(x) · g(x)] = lim(x→c) f(x) · lim(x→c) g(x)
                3. lim(x→c) [f(x) / g(x)] = lim(x→c) f(x) / lim(x→c) g(x), si lim(x→c) g(x) ≠ 0

                Ejemplos:
                1. Evaluar lim(x→2) (3x - 4)
                   Solución: lim(x→2) (3x - 4) = 3(2) - 4 = 6 - 4 = 2

                2. Determinar lim(x→0) (sin x) / x
                   Solución: Este es un límite fundamental. lim(x→0) (sin x) / x = 1

                3. Encontrar lim(x→∞) (x² + 2x) / (3x² - 1)
                   Solución: Dividir numerador y denominador por x²:
                   lim(x→∞) (1 + 2/x) / (3 - 1/x²) = 1/3

                Técnicas para evaluar límites:
                • Sustitución directa
                • Factorización
                • Racionalización
                • Uso de límites notables
                • Regla de L'Hôpital (para formas indeterminadas)
            """.trimIndent()
                ),
                Topic(
                    title = "Derivadas",
                    definition = "La derivada de una función representa su tasa de cambio instantánea y proporciona información sobre el comportamiento y las propiedades de la función.",
                    terms = """
                • Tasa de cambio instantánea
                • Pendiente de la recta tangente
                • Diferenciabilidad
                • Regla de la cadena
                • Derivadas de orden superior
                • Máximo y mínimo locales
                • Puntos de inflexión
                • Concavidad
            """.trimIndent(),
                    description = """
                Notación:
                f'(x), df/dx, d/dx[f(x)], Dᵪf(x)

                Reglas básicas de derivación:
                1. d/dx[x^n] = nx^(n-1)
                2. d/dx[e^x] = e^x
                3. d/dx[ln(x)] = 1/x
                4. d/dx[sin(x)] = cos(x)
                5. d/dx[cos(x)] = -sin(x)

                Reglas de derivación compuestas:
                • Regla del producto: d/dx[f(x)g(x)] = f'(x)g(x) + f(x)g'(x)
                • Regla del cociente: d/dx[f(x)/g(x)] = [f'(x)g(x) - f(x)g'(x)] / [g(x)]²
                • Regla de la cadena: d/dx[f(g(x))] = f'(g(x)) · g'(x)

                Ejemplos:
                1. Derivar f(x) = x²
                   f'(x) = 2x

                2. Hallar la derivada de f(x) = e^(x²)
                   f'(x) = e^(x²) · 2x  (usando la regla de la cadena)

                3. Encontrar la ecuación de la recta tangente a f(x) = x³ - 2x + 1 en x = 1
                   f'(x) = 3x² - 2
                   f'(1) = 3(1)² - 2 = 1
                   y - f(1) = f'(1)(x - 1)
                   y - 0 = 1(x - 1)
                   y = x - 1

                Aplicaciones de las derivadas:
                • Optimización
                • Análisis de crecimiento y decrecimiento
                • Aproximaciones lineales
                • Teorema del valor medio
                • Regla de L'Hôpital
            """.trimIndent()
                ),
                Topic(
                    title = "Integrales",
                    definition = "La integral es una operación que permite calcular el área bajo una curva, la acumulación de cantidades, o revertir el proceso de diferenciación.",
                    terms = """
                • Integral definida
                • Integral indefinida
                • Antiderivada
                • Teorema Fundamental del Cálculo
                • Integración por partes
                • Integración por sustitución
                • Fracciones parciales
            """.trimIndent(),
                    description = """
                Notación:
                Integral indefinida: ∫ f(x) dx
                Integral definida: ∫ₐᵇ f(x) dx

                Propiedades básicas:
                1. ∫ [f(x) ± g(x)] dx = ∫ f(x) dx ± ∫ g(x) dx
                2. ∫ kf(x) dx = k∫ f(x) dx  (k es constante)
                3. ∫ₐᵇ f(x) dx = -∫ᵇₐ f(x) dx

                Integrales básicas:
                1. ∫ x^n dx = (x^(n+1))/(n+1) + C,  n ≠ -1
                2. ∫ 1/x dx = ln|x| + C
                3. ∫ e^x dx = e^x + C
                4. ∫ sin(x) dx = -cos(x) + C
                5. ∫ cos(x) dx = sin(x) + C

                Teorema Fundamental del Cálculo:
                Si F(x) es una antiderivada de f(x), entonces
                ∫ₐᵇ f(x) dx = F(b) - F(a)

                Ejemplos:
                1. Calcular ∫ (2x + 3) dx
                   Solución: ∫ (2x + 3) dx = x² + 3x + C

                2. Evaluar ∫₀² (x² + 1) dx
                   F(x) = (x³/3) + x
                   ∫₀² (x² + 1) dx = F(2) - F(0) = [(8/3) + 2] - [0 + 0] = 14/3

                3. Usar integración por partes para ∫ x·ln(x) dx
                   u = ln(x), dv = x dx
                   du = (1/x) dx, v = (x²/2)
                   ∫ x·ln(x) dx = (x²/2)·ln(x) - ∫ (x²/2)·(1/x) dx
                                = (x²/2)·ln(x) - (x²/4) + C

                Aplicaciones de las integrales:
                • Cálculo de áreas y volúmenes
                • Longitud de arco
                • Centroides y momentos de inercia
                • Trabajo y energía en física
                • Probabilidad y valor esperado en estadística
            """.trimIndent()
                )
            ),
            imageUrl = R.drawable.calculo,
            isFavorite = false
        ),
        Subject(
            title = "Aritmética",
            description = "Conceptos fundamentales y aplicaciones de la aritmética, incluyendo operaciones básicas, propiedades, y ejemplos prácticos.",
            amount = "15 temas",
            topics = listOf(
                Topic(
                    title = "Operaciones Básicas",
                    definition = "Las operaciones fundamentales de la aritmética incluyen la adición, sustracción, multiplicación y división.",
                    terms = """
                • Adición
                • Sustracción
                • Multiplicación
                • División
                • Propiedades
            """.trimIndent(),
                    description = """
                Adición:
                La operación de sumar dos o más números.
                Ejemplo: 2 + 3 = 5

                Sustracción:
                La operación de restar un número de otro.
                Ejemplo: 5 - 3 = 2

                Multiplicación:
                La operación de multiplicar dos o más números.
                Ejemplo: 2 * 3 = 6

                División:
                La operación de dividir un número entre otro.
                Ejemplo: 6 / 2 = 3

                Propiedades:
                • Conmutatividad: a + b = b + a, a * b = b * a
                • Asociatividad: (a + b) + c = a + (b + c)
                • Distributividad: a * (b + c) = (a * b) + (a * c)
            """.trimIndent()
                ),
                Topic(
                    title = "Números Enteros y Decimales",
                    definition = "Los números enteros incluyen todos los números positivos y negativos sin fracción, mientras que los decimales incluyen una parte fraccionaria.",
                    terms = """
                • Números enteros
                • Números decimales
                • Parte entera
                • Parte decimal
                • Notación decimal
            """.trimIndent(),
                    description = """
                Números enteros:
                Incluyen los números positivos, negativos y el cero.
                Ejemplo: -3, -2, -1, 0, 1, 2, 3

                Números decimales:
                Números que tienen una parte fraccionaria.
                Ejemplo: 2.5, 3.14, -1.75

                Parte entera y decimal:
                En 3.14, la parte entera es 3 y la parte decimal es 0.14.

                Notación decimal:
                Se utiliza para representar fracciones como decimales.
                Ejemplo: 1/2 = 0.5
            """.trimIndent()
                ),
                Topic(
                    title = "Fracciones y Porcentajes",
                    definition = "Las fracciones representan partes de un todo, mientras que los porcentajes representan fracciones con un denominador de 100.",
                    terms = """
                • Fracción
                • Numerador
                • Denominador
                • Porcentaje
                • Conversión
            """.trimIndent(),
                    description = """
                Fracción:
                Representa una parte de un todo.
                Ejemplo: 1/2, 3/4

                Numerador y denominador:
                En 3/4, 3 es el numerador y 4 es el denominador.

                Porcentaje:
                Representa una fracción con denominador 100.
                Ejemplo: 50% = 50/100 = 1/2

                Conversión entre fracciones y porcentajes:
                Para convertir una fracción a porcentaje, multiplica por 100.
                Ejemplo: 3/4 * 100 = 75%
            """.trimIndent()
                ),
                Topic(
                    title = "Propiedades de los Números",
                    definition = "Propiedades importantes de los números incluyen la propiedad conmutativa, asociativa y distributiva.",
                    terms = """
                • Propiedad conmutativa
                • Propiedad asociativa
                • Propiedad distributiva
                • Identidad aditiva
                • Inverso aditivo
            """.trimIndent(),
                    description = """
                Propiedad conmutativa:
                El orden de los números no afecta el resultado.
                Ejemplo: a + b = b + a

                Propiedad asociativa:
                La agrupación de los números no afecta el resultado.
                Ejemplo: (a + b) + c = a + (b + c)

                Propiedad distributiva:
                Multiplicar un número por una suma es igual a multiplicar el número por cada término y luego sumar.
                Ejemplo: a * (b + c) = (a * b) + (a * c)

                Identidad aditiva:
                El número 0 es la identidad aditiva porque cualquier número más 0 es el número mismo.
                Ejemplo: a + 0 = a

                Inverso aditivo:
                Para cada número hay un número que, al sumarlo, da 0.
                Ejemplo: a + (-a) = 0
            """.trimIndent()
                )
            ),
            imageUrl = R.drawable.aritmetica,
            isFavorite = false
        ),

                Subject(
            title = "Geometría",
            description = "Estudio de las propiedades, medidas y relaciones de puntos, líneas, ángulos, superficies y sólidos en el espacio.",
            amount = "30 temas",
            topics = listOf(
                Topic(
                    title = "Ángulos",
                    definition = "Un ángulo es la figura formada por dos rayos que comparten un punto final común, llamado vértice.",
                    terms = """
                • Vértice
                • Lados del ángulo
                • Ángulo recto (90°)
                • Ángulo agudo (<90°)
                • Ángulo obtuso (>90°)
                • Ángulos complementarios
                • Ángulos suplementarios
                • Ángulos opuestos por el vértice
                • Bisectriz
            """.trimIndent(),
                    description = """
                Medición de ángulos:
                • Grados: 1 vuelta completa = 360°
                • Radianes: 1 vuelta completa = 2π radianes

                Conversión entre grados y radianes:
                θ_radianes = (θ_grados · π) / 180°
                θ_grados = (θ_radianes · 180°) / π

                Propiedades de los ángulos:
                1. Ángulos en una línea recta suman 180°
                2. Ángulos en un punto suman 360°
                3. Ángulos opuestos por el vértice son iguales
                4. Ángulos alternos internos entre paralelas son iguales

                Teoremas importantes:
                • Suma de ángulos internos de un triángulo = 180°
                • Suma de ángulos internos de un polígono de n lados = (n - 2) · 180°
                • Teorema del ángulo exterior: Un ángulo exterior de un triángulo es igual a la suma de los dos ángulos interiores no adyacentes

                Ejemplos:
                1. En un triángulo con ángulos de 45° y 60°, calcular el tercer ángulo:
                   180° - 45° - 60° = 75°

                2. Calcular el ángulo central de un polígono regular de 8 lados:
                   Ángulo central = 360° / 8 = 45°

                3. Si dos rectas se cortan formando un ángulo de 35°, ¿cuánto miden los otros tres ángulos formados?
                   Ángulos opuestos por el vértice: 35° y 35°
                   Ángulos suplementarios: 180° - 35° = 145° y 145°

                Aplicaciones:
                • Trigonometría
                • Navegación
                • Arquitectura y diseño
                • Física (óptica, mecánica)
                • Astronomía
            """.trimIndent()
                ),
                Topic(
                    title = "Círculos",
                    definition = "Un círculo es el conjunto de todos los puntos en un plano que están a una distancia fija, llamada radio, de un punto central.",
                    terms = """
                • Centro
                • Radio
                • Diámetro
                • Circunferencia
                • Cuerda
                • Secante
                • Tangente
                • Sector circular
                • Segmento circular
                • Ángulo central
                • Ángulo inscrito
            """.trimIndent(),
                    description = """
                Fórmulas fundamentales:
                • Área del círculo: A = πr²
                • Circunferencia: C = 2πr
                • Longitud de arco: L = (θ/360°) · 2πr, donde θ es el ángulo central en grados

                Propiedades importantes:
                1. El diámetro es dos veces el radio
                2. Todos los radios de un círculo son congruentes
                3. Una tangente es perpendicular al radio en el punto de tangencia
                4. El ángulo inscrito es la mitad del ángulo central que subtiende el mismo arco

                Teoremas del círculo:
                • Teorema de la tangente-secante
                • Teorema de las cuerdas
                • Teorema del ángulo inscrito
                • Teorema de Ptolomeo

                Ejemplos:
                1. Calcular el área de un círculo con radio 5 cm:
                   A = π · 5² = 25π ≈ 78.54 cm²

                2. Hallar la longitud de un arco que subtiende un ángulo central de 60° en un círculo de radio 10 cm:
                   L = (60°/360°) · 2π · 10 = (π/3) · 10 ≈ 10.47 cm

                3. En un círculo de radio 8 cm, una cuerda está a 6 cm del centro. Calcular la longitud de la cuerda:
                   Usando el teorema de Pitágoras: 8² = 6² + (x/2)²
                   x = 2√(8² - 6²) = 2√28 ≈ 10.58 cm

                Aplicaciones de los círculos:
                • Diseño de engranajes y ruedas
                • Astronomía (órbitas planetarias)
                • Trigonometría (funciones circulares)
                • Arquitectura (arcos y cúpulas)
                • Tecnología (lentes, antenas parabólicas)
                • Arte y diseño gráfico
            """.trimIndent()
                ),
                Topic(
                    title = "Triángulos",
                    definition = "Un triángulo es un polígono de tres lados y tres ángulos.",
                    terms = """
                • Vértices
                • Lados
                • Ángulos internos
                • Base y altura
                • Mediana
                • Bisectriz
                • Mediatriz
                • Incentro
                • Circuncentro
                • Baricentro
                • Ortocentro
            """.trimIndent(),
                    description = """
                Clasificación de triángulos:
                • Por lados: Equilátero, Isósceles, Escaleno
                • Por ángulos: Acutángulo, Rectángulo, Obtusángulo

                Propiedades básicas:
                1. Suma de ángulos internos = 180°
                2. Suma de las longitudes de dos lados > longitud del tercer lado
                3. Ángulo exterior = suma de los dos ángulos internos no adyacentes

                Fórmulas importantes:
                • Área: A = (1/2) · base · altura
                • Semiperímetro: s = (a + b + c) / 2
                • Fórmula de Herón: A = √[s(s-a)(s-b)(s-c)]
                • Teorema de Pitágoras: a² + b² = c² (en triángulos rectángulos)

                Teoremas y conceptos avanzados:
                • Teorema del seno: a/sin A = b/sin B = c/sin C = 2R
                  (donde R es el radio del circuncírculo)
                • Teorema del coseno: c² = a² + b² - 2ab cos C
                • Teorema de la bisectriz: La bisectriz de un ángulo divide al lado opuesto en segmentos proporcionales a los otros dos lados
                • Teorema de Ceva: Relaciona las longitudes de los segmentos formados por las cevianas de un triángulo
                • Teorema de Menelao: Relaciona las longitudes de los segmentos formados por una recta que corta los lados de un triángulo

                Puntos notables:
                • Incentro: Punto de intersección de las bisectrices
                • Circuncentro: Punto de intersección de las mediatrices
                • Baricentro: Punto de intersección de las medianas
                • Ortocentro: Punto de intersección de las alturas

                Ejemplos:
                1. Calcular el área de un triángulo con lados 3, 4 y 5:
                   s = (3 + 4 + 5) / 2 = 6
                   A = √[6(6-3)(6-4)(6-5)] = √(6·3·2·1) = √36 = 6 unidades cuadradas

                2. En un triángulo rectángulo, si un cateto mide 8 y la hipotenusa 17, calcular el otro cateto:
                   Usando el teorema de Pitágoras: 8² + x² = 17²
                   x² = 17² - 8² = 289 - 64 = 225
                   x = √225 = 15

                3. En un triángulo ABC, si A = 60°, b = 10 cm, y c = 12 cm, calcular el lado a:
                   Usando el teorema del coseno:
                   a² = 10² + 12² - 2(10)(12)cos 60°
                   a² = 100 + 144 - 240(1/2) = 124
                   a = √124 ≈ 11.14 cm

                Aplicaciones de los triángulos:
                • Agrimensura y cartografía
                • Arquitectura y construcción
                • Navegación y GPS
                • Física (descomposición de fuerzas)
                • Diseño gráfico y animación 3D
                • Trigonometría y funciones trigonométricas
            """.trimIndent()
                ),
                Topic(
                    title = "Geometría Analítica",
                    definition = "La geometría analítica combina el álgebra y la geometría, utilizando un sistema de coordenadas para representar figuras geométricas mediante ecuaciones algebraicas.",
                    terms = """
                • Sistema de coordenadas cartesianas
                • Punto
                • Distancia entre dos puntos
                • Pendiente de una recta
                • Ecuación de la recta
                • Paralelismo y perpendicularidad
                • Cónicas (circunferencia, elipse, parábola, hipérbola)
            """.trimIndent(),
                    description = """
                Fórmulas fundamentales:
                • Distancia entre puntos: d = √[(x₂-x₁)² + (y₂-y₁)²]
                • Punto medio: M((x₁+x₂)/2, (y₁+y₂)/2)
                • Pendiente: m = (y₂-y₁)/(x₂-x₁)
                • Ecuación de la recta:
                  - Punto-pendiente: y - y₁ = m(x - x₁)
                  - General: Ax + By + C = 0
                  - Pendiente-intersección: y = mx + b

                Cónicas:
                • Circunferencia: (x-h)² + (y-k)² = r²
                • Elipse: (x-h)²/a² + (y-k)²/b² = 1
                • Parábola: 4p(y-k) = (x-h)²  (eje vertical)
                • Hipérbola: (x-h)²/a² - (y-k)²/b² = 1  (eje transverso horizontal)

                Ejemplos:
                1. Hallar la distancia entre los puntos A(3, 4) y B(-2, 7):
                   d = √[(3-(-2))² + (4-7)²] = √(5² + (-3)²) = √34 ≈ 5.83 unidades

                2. Encontrar la ecuación de la recta que pasa por (1, 2) y tiene pendiente 3:
                   Usando la forma punto-pendiente:
                   y - 2 = 3(x - 1)
                   y = 3x - 1

                3. Determinar la ecuación de la circunferencia con centro en (2, -1) y radio 5:
                   (x-2)² + (y+1)² = 5²
                   (x-2)² + (y+1)² = 25

                Aplicaciones de la geometría analítica:
                • Gráficos por computadora
                • Diseño asistido por computadora (CAD)
                • Física (trayectorias de proyectiles, órbitas)
                • Economía (curvas de oferta y demanda)
                • Robótica y control de movimiento
                • Sistemas de posicionamiento global (GPS)
            """.trimIndent()
                )
            ),
            imageUrl = R.drawable.geometria1,
            isFavorite = false
        ),
        Subject(
            title = "Estadística",
            description = "Ciencia de la recolección, análisis, interpretación y presentación de datos para la toma de decisiones informadas y la comprensión de fenómenos.",
            amount = "25 temas",
            topics = listOf(
                Topic(
                    title = "Medidas de Tendencia Central",
                    definition = "Las medidas de tendencia central son valores únicos que intentan describir un conjunto de datos representando el centro de su distribución.",
                    terms = """
                • Media aritmética
                • Mediana
                • Moda
                • Media ponderada
                • Media geométrica
                • Media armónica
            """.trimIndent(),
                    description = """
                1. Media aritmética (x̄):
                   x̄ = (∑ x_i) / n
                   Donde x_i son los valores individuales y n es el número total de valores.

                2. Mediana:
                   - Para n impar: valor central de los datos ordenados.
                   - Para n par: promedio de los dos valores centrales.

                3. Moda: valor más frecuente en el conjunto de datos.

                Ejemplo:
                Conjunto de datos: 2, 3, 3, 4, 5, 5, 6, 8

                Media: (2 + 3 + 3 + 4 + 5 + 5 + 6 + 8) / 8 = 36 / 8 = 4.5
                Mediana: (4 + 5) / 2 = 4.5 (datos ordenados, n par)
                Moda: 3 y 5 (distribución bimodal)

                Propiedades:
                • La media es sensible a valores extremos (outliers).
                • La mediana es resistente a valores extremos.
                • La moda puede no existir o no ser única.

                Aplicaciones:
                • Economía: ingreso promedio, mediana de precios de viviendas
                • Educación: calificaciones promedio, mediana de puntajes de exámenes
                • Meteorología: temperaturas medias, precipitación modal
            """.trimIndent()
                ),
                Topic(
                    title = "Medidas de Dispersión",
                    definition = "Las medidas de dispersión cuantifican la variabilidad o spread de un conjunto de datos, indicando cuánto se desvían los valores de las medidas de tendencia central.",
                    terms = """
                • Rango
                • Varianza
                • Desviación estándar
                • Coeficiente de variación
                • Rango intercuartílico (IQR)
                • Desviación media absoluta
            """.trimIndent(),
                    description = """
                1. Varianza (σ²):
                   σ² = ∑(x_i - x̄)² / (n - 1)  (para una muestra)
                   σ² = ∑(x_i - μ)² / N        (para una población)

                2. Desviación estándar (σ):
                   σ = √σ²

                3. Coeficiente de variación (CV):
                   CV = (σ / x̄) × 100%

                Ejemplo:
                Conjunto de datos: 2, 4, 4, 4, 5, 5, 7, 9

                Media (x̄) = (2 + 4 + 4 + 4 + 5 + 5 + 7 + 9) / 8 = 5

                Varianza:
                σ² = [(2-5)² + (4-5)² + (4-5)² + (4-5)² + (5-5)² + (5-5)² + (7-5)² + (9-5)²] / (8-1)
                   = (9 + 1 + 1 + 1 + 0 + 0 + 4 + 16) / 7
                   = 32 / 7 ≈ 4.57

                Desviación estándar:
                σ = √4.57 ≈ 2.14

                Coeficiente de variación:
                CV = (2.14 / 5) × 100% ≈ 42.8%

                Interpretación:
                • La desviación estándar (2.14) indica que, en promedio, los valores se desvían 2.14 unidades de la media.
                • El CV de 42.8% sugiere una dispersión moderada en relación con la media.

                Aplicaciones:
                • Finanzas: medición de la volatilidad de activos
                • Control de calidad: variabilidad en procesos de manufactura
                • Ciencias sociales: dispersión de opiniones en encuestas
                • Meteorología: variabilidad climática
            """.trimIndent()
                ),
                Topic(
                    title = "Distribuciones de Probabilidad",
                    definition = "Una distribución de probabilidad es un modelo matemático que describe la probabilidad de ocurrencia de cada resultado posible en un experimento aleatorio.",
                    terms = """
                • Distribución discreta
                • Distribución continua
                • Función de masa de probabilidad (PMF)
                • Función de densidad de probabilidad (PDF)
                • Función de distribución acumulativa (CDF)
                • Esperanza (valor esperado)
                • Varianza
            """.trimIndent(),
                    description = """
                Distribuciones discretas comunes:
                1. Binomial: B(n, p)
                   PMF: P(X = k) = C(n,k) * p^k * (1-p)^(n-k)
                   Ejemplo: Lanzar una moneda 10 veces y contar caras

                2. Poisson: Pois(λ)
                   PMF: P(X = k) = (e^(-λ) * λ^k) / k!
                   Ejemplo: Número de llamadas a un call center por hora

                Distribuciones continuas comunes:
                1. Normal: N(μ, σ²)
                   PDF: f(x) = (1 / (σ√(2π))) * e^(-(x-μ)²/(2σ²))
                   Ejemplo: Alturas en una población

                2. Exponencial: Exp(λ)
                   PDF: f(x) = λe^(-λx), para x ≥ 0
                   Ejemplo: Tiempo entre llegadas de clientes a una tienda

                Propiedades de la distribución normal:
                • Simétrica alrededor de la media (μ)
                • La media, mediana y moda son iguales
                • Aproximadamente 68% de los datos están dentro de 1σ de μ
                • Aproximadamente 95% de los datos están dentro de 2σ de μ
                • Aproximadamente 99.7% de los datos están dentro de 3σ de μ

                Aplicaciones:
                • Control de calidad: modelado de variaciones en procesos
                • Finanzas: modelado de retornos de inversiones
                • Ciencias sociales: distribución de características en poblaciones
                • Teoría de colas: modelado de tiempos de espera y servicio
            """.trimIndent()
                ),
                Topic(
                    title = "Inferencia Estadística",
                    definition = "La inferencia estadística es el proceso de usar datos de una muestra para hacer estimaciones, predicciones o decisiones sobre una población más grande.",
                    terms = """
                • Población vs. Muestra
                • Parámetro vs. Estadístico
                • Estimación puntual
                • Intervalo de confianza
                • Prueba de hipótesis
                • Nivel de significancia (α)
                • Valor p
                • Error Tipo I y Tipo II
            """.trimIndent(),
                    description = """
                Estimación de intervalo de confianza:
                Para la media poblacional (μ) con σ conocida:
                IC = x̄ ± (z_(α/2) * σ / √n)

                Donde:
                x̄ = media muestral
                z_(α/2) = valor crítico de la distribución normal estándar
                σ = desviación estándar poblacional
                n = tamaño de la muestra

                Ejemplo:
                Una muestra de 100 estudiantes tiene una altura media de 170 cm con una desviación estándar de 5 cm. Calcular un intervalo de confianza del 95% para la media poblacional.

                Solución:
                x̄ = 170 cm
                n = 100
                σ = 5 cm
                z_(0.025) = 1.96 (para un 95% de confianza)

                IC = 170 ± (1.96 * 5 / √100)
                   = 170 ± 0.98
                   = (169.02, 170.98)

                Interpretación: Estamos 95% confiados de que la verdadera media poblacional de altura está entre 169.02 cm y 170.98 cm.

                Prueba de hipótesis:
                Pasos generales:
                1. Formular hipótesis nula (H₀) y alternativa (H₁)
                2. Elegir nivel de significancia (α)
                3. Calcular estadístico de prueba
                4. Determinar región crítica o calcular valor p
                5. Tomar decisión y concluir

                Aplicaciones:
                • Medicina: eficacia de tratamientos
                • Marketing: preferencias del consumidor
                • Ingeniería: control de calidad
                • Ciencias sociales: tendencias demográficas
            """.trimIndent()
                )
            ),
            imageUrl = R.drawable.estadistic,
            isFavorite = false
        ),
        Subject(
            title = "Trigonometría",
            description = "Estudio de las relaciones entre los ángulos y los lados de los triángulos, así como de las funciones trigonométricas y sus aplicaciones en matemáticas y ciencias.",
            amount = "28 temas",
            topics = listOf(
                Topic(
                    title = "Funciones Trigonométricas",
                    definition = "Las funciones trigonométricas son relaciones fundamentales entre los ángulos y los lados de un triángulo rectángulo, que se extienden a funciones periódicas en el círculo unitario.",
                    terms = """
                • Seno (sin)
                • Coseno (cos)
                • Tangente (tan)
                • Cosecante (csc)
                • Secante (sec)
                • Cotangente (cot)
                • Radianes
                • Círculo unitario
            """.trimIndent(),
                    description = """
                Definiciones en triángulo rectángulo:
                • sin(θ) = cateto opuesto / hipotenusa
                • cos(θ) = cateto adyacente / hipotenusa
                • tan(θ) = cateto opuesto / cateto adyacente = sin(θ) / cos(θ)
                • csc(θ) = 1 / sin(θ)
                • sec(θ) = 1 / cos(θ)
                • cot(θ) = 1 / tan(θ) = cos(θ) / sin(θ)

                Valores notables:
                θ    | 0°   | 30°       | 45°       | 60°       | 90°
                sin  | 0    | 1/2       | √2/2      | √3/2      | 1
                cos  | 1    | √3/2      | √2/2      | 1/2       | 0
                tan  | 0    | √3/3      | 1         | √3        | ∞

                Propiedades:
                • Periodicidad: sin(θ + 2π) = sin(θ), cos(θ + 2π) = cos(θ)
                • Paridad: sin(-θ) = -sin(θ), cos(-θ) = cos(θ)
                • Identidad fundamental: sin²(θ) + cos²(θ) = 1

                Ejemplo:
                Calcular sin(30°) y cos(30°):
                sin(30°) = 1/2
                cos(30°) = √3/2

                Aplicaciones:
                • Física: descomposición de fuerzas, movimiento armónico simple
                • Ingeniería: análisis de ondas, diseño de estructuras
                • Navegación: cálculo de distancias y direcciones
                • Astronomía: medición de distancias celestiales
            """.trimIndent()
                ),
                Topic(
                    title = "Identidades Trigonométricas",
                    definition = "Las identidades trigonométricas son ecuaciones que relacionan funciones trigonométricas y son verdaderas para todos los valores del ángulo para los que están definidas.",
                    terms = """
                • Identidades fundamentales
                • Identidades de suma y diferencia
                • Identidades de ángulo doble
                • Identidades de ángulo mitad
                • Fórmulas de producto a suma
                • Fórmulas de suma a producto
            """.trimIndent(),
                    description = """
                Identidades fundamentales:
                1. sin²θ + cos²θ = 1
                2. 1 + tan²θ = sec²θ
                3. 1 + cot²θ = csc²θ

                Identidades de suma y diferencia:
                1. sin(A ± B) = sinA cosB ± cosA sinB
                2. cos(A ± B) = cosA cosB ∓ sinA sinB
                3. tan(A ± B) = (tanA ± tanB) / (1 ∓ tanA tanB)

                Identidades de ángulo doble:
                1. sin(2θ) = 2sinθ cosθ
                2. cos(2θ) = cos²θ - sin²θ = 2cos²θ - 1 = 1 - 2sin²θ
                3. tan(2θ) = 2tanθ / (1 - tan²θ)

                Ejemplo:
                Demostrar que cos²θ - sin²θ = cos(2θ)

                Demostración:
                cos²θ - sin²θ = (cos²θ + sin²θ) - 2sin²θ
                               = 1 - 2sin²θ  (usando sin²θ + cos²θ = 1)
                               = cos(2θ)  (por la identidad de ángulo doble)

                Aplicaciones:
                • Simplificación de expresiones trigonométricas complejas
                • Resolución de ecuaciones trigonométricas
                • Derivación de fórmulas en física y ingeniería
                • Análisis de Fourier y procesamiento de señales
            """.trimIndent()
                ),
                Topic(
                    title = "Leyes de Senos y Cosenos",
                    definition = "Las leyes de senos y cosenos son fórmulas que permiten resolver triángulos no rectángulos, relacionando los lados y los ángulos del triángulo.",
                    terms = """
                • Ley de senos
                • Ley de cosenos
                • Área de un triángulo
                • Caso ambiguo (SSA)
            """.trimIndent(),
                    description = """
                Ley de Senos:
                a / sin(A) = b / sin(B) = c / sin(C) = 2R
                Donde R es el radio del circuncírculo del triángulo.

                Ley de Cosenos:
                c² = a² + b² - 2ab cos(C)
                Generalizaciones:
                a² = b² + c² - 2bc cos(A)
                b² = a² + c² - 2ac cos(B)

                Área del triángulo:
                Área = (1/2)ab sin(C)

                Ejemplo:
                En un triángulo ABC, a = 8, b = 6, y C = 45°. Encontrar c.

                Solución usando la Ley de Cosenos:
                c² = 8² + 6² - 2(8)(6)cos(45°)
                   = 64 + 36 - 96cos(45°)
                   = 100 - 96(√2/2)
                   = 100 - 48√2
                c  = √(100 - 48√2) ≈ 5.65

                Aplicaciones:
                • Topografía y cartografía
                • Navegación marítima y aérea
                • Astronomía: cálculo de distancias y posiciones estelares
                • Arquitectura y construcción
                • Física: análisis de fuerzas y vectores
            """.trimIndent()
                ),
                Topic(
                    title = "Ecuaciones Trigonométricas",
                    definition = "Las ecuaciones trigonométricas son ecuaciones que involucran una o más funciones trigonométricas y requieren encontrar valores del ángulo que satisfacen la ecuación.",
                    terms = """
                • Ecuación trigonométrica
                • Solución general
                • Periodo
                • Ecuaciones cuadráticas trigonométricas
                • Factorización
                • Sustitución trigonométrica
            """.trimIndent(),
                    description = """
                Tipos comunes de ecuaciones:
                1. Ecuaciones lineales: asin(x) + b = 0
                2. Ecuaciones cuadráticas: asin²(x) + bsin(x) + c = 0
                3. Ecuaciones con múltiples funciones: sin(x) = cos(x)
                4. Ecuaciones con ángulos compuestos: sin(2x) = 1/2

                Métodos de resolución:
                • Uso de valores notables
                • Factorización
                • Sustitución trigonométrica
                • Uso de identidades trigonométricas
                • Método gráfico

                Ejemplo:
                Resolver la ecuación: 2sin²(x) - sin(x) - 1 = 0

                Solución:
                1. Tratar sin(x) como una variable: let u = sin(x)
                2. Reescribir la ecuación: 2u² - u - 1 = 0
                3. Resolver la ecuación cuadrática:
                   u = (1 ± √9) / 4 = 1/2 or -1
                4. Volver a x:
                   sin(x) = 1/2 o sin(x) = -1
                5. Soluciones en [0, 2π]:
                   x = π/6 o 5π/6 (para sin(x) = 1/2)
                   x = 3π/2 (para sin(x) = -1)

                Solución general:
                x = π/6 + 2πn o 5π/6 + 2πn o 3π/2 + 2πn, donde n es un entero

                Aplicaciones:
                • Análisis de oscilaciones y movimientos periódicos
                • Procesamiento de señales y análisis armónico
                • Modelado de fenómenos cíclicos en economía y ciencias naturales
                • Resolución de problemas en electromagnetismo y óptica
            """.trimIndent()
                )
            ),
            imageUrl = R.drawable.trigonometria,
            isFavorite = false
        ),
        Subject(
            title = "Números Complejos",
            description = "Estudio de los números que extienden el sistema de números reales, incluyendo la unidad imaginaria i, sus operaciones, propiedades y aplicaciones en matemáticas, física e ingeniería.",
            amount = "25 temas",
            topics = listOf(
                Topic(
                    title = "Definición y Representación",
                    definition = "Un número complejo es una expresión de la forma a + bi, donde a y b son números reales, e i es la unidad imaginaria definida como i² = -1.",
                    terms = """
                • Parte real
                • Parte imaginaria
                • Unidad imaginaria (i)
                • Plano complejo
                • Forma binómica
                • Forma polar
                • Conjugado complejo
            """.trimIndent(),
                    description = """
                Representación:
                z = a + bi, donde:
                a: parte real (Re(z))
                b: parte imaginaria (Im(z))
                i: unidad imaginaria (i² = -1)

                Plano complejo:
                • Eje horizontal: parte real
                • Eje vertical: parte imaginaria

                Forma polar:
                z = r(cos θ + i sin θ) = r∠θ
                r: módulo (|z| = √(a² + b²))
                θ: argumento (arg(z) = arctan(b/a))

                Conjugado complejo:
                z̄ = a - bi

                Ejemplo:
                Para z = 3 + 4i:
                • Parte real: Re(z) = 3
                • Parte imaginaria: Im(z) = 4
                • Módulo: |z| = √(3² + 4²) = 5
                • Argumento: arg(z) = arctan(4/3) ≈ 0.927 radianes ≈ 53.13°
                • Forma polar: 5(cos 53.13° + i sin 53.13°)
                • Conjugado: z̄ = 3 - 4i

                Aplicaciones:
                • Electrónica: análisis de circuitos AC
                • Física cuántica: funciones de onda
                • Procesamiento de señales: transformadas de Fourier
                • Aerodinámica: flujo potencial
            """.trimIndent()
                ),
                Topic(
                    title = "Operaciones Básicas",
                    definition = "Las operaciones fundamentales con números complejos incluyen suma, resta, multiplicación y división, cada una con sus propias reglas y propiedades.",
                    terms = """
                • Adición
                • Sustracción
                • Multiplicación
                • División
                • Potenciación
                • Radicación
            """.trimIndent(),
                    description = """
                Sean z₁ = a + bi y z₂ = c + di:

                1. Adición:
                   z₁ + z₂ = (a + c) + (b + d)i

                2. Sustracción:
                   z₁ - z₂ = (a - c) + (b - d)i

                3. Multiplicación:
                   z₁ · z₂ = (ac - bd) + (ad + bc)i

                4. División:
                   z₁ / z₂ = (ac + bd)/(c² + d²) + [(bc - ad)/(c² + d²)]i

                5. Potenciación (Fórmula de De Moivre):
                   (r∠θ)ⁿ = rⁿ∠nθ = rⁿ(cos(nθ) + i sin(nθ))

                6. Radicación:
                   ⁿ√(r∠θ) = ⁿ√r ∠(θ + 2kπ)/n, k = 0, 1, ..., n-1

                Ejemplos:
                1. (3 + 4i) + (1 - 2i) = 4 + 2i
                2. (2 + 3i)(4 - i) = (8 + 12i) + (-2i - 3i²) = 11 + 10i

                Propiedades:
                • Conmutatividad: z₁ + z₂ = z₂ + z₁, z₁ · z₂ = z₂ · z₁
                • Asociatividad: (z₁ + z₂) + z₃ = z₁ + (z₂ + z₃)
                • Distributividad: z₁(z₂ + z₃) = z₁z₂ + z₁z₃

                Aplicaciones:
                • Ingeniería eléctrica: análisis de impedancia
                • Geometría: rotaciones y escalados en el plano complejo
                • Teoría de control: análisis de sistemas lineales
                • Fractales: conjunto de Mandelbrot y Julia
            """.trimIndent()
                ),
                Topic(
                    title = "Ecuaciones con Números Complejos",
                    definition = "Las ecuaciones con números complejos involucran incógnitas que pueden tomar valores complejos y requieren técnicas específicas para su resolución.",
                    terms = """
                • Ecuación cuadrática compleja
                • Raíces complejas
                • Factorización
                • Teorema fundamental del álgebra
                • Polinomios con coeficientes complejos
            """.trimIndent(),
                    description = """
                Ecuación cuadrática general:
                az² + bz + c = 0, donde a, b, c ∈ ℂ

                Fórmula cuadrática:
                z = [-b ± √(b² - 4ac)] / (2a)

                Teorema fundamental del álgebra:
                Todo polinomio de grado n con coeficientes complejos tiene exactamente n raíces complejas (contando multiplicidades).

                Ejemplo 1:
                Resolver z² + 4z + 13 = 0

                Solución:
                z = [-4 ± √(4² - 4(1)(13))] / (2(1))
                  = [-4 ± √(-36)] / 2
                  = [-4 ± 6i] / 2
                  = -2 ± 3i

                Raíces: z₁ = -2 + 3i, z₂ = -2 - 3i

                Ejemplo 2:
                Encontrar las raíces cúbicas de 1

                Solución:
                ³√1 = 1∠(0° + 360°k)/3, k = 0, 1, 2

                z₀ = 1∠0° = 1
                z₁ = 1∠120° = -1/2 + (√3/2)i
                z₂ = 1∠240° = -1/2 - (√3/2)i

                Aplicaciones:
                • Teoría de control: análisis de estabilidad
                • Física cuántica: soluciones de la ecuación de Schrödinger
                • Ingeniería eléctrica: análisis de circuitos resonantes
                • Computación gráfica: transformaciones geométricas complejas
            """.trimIndent()
                ),
                Topic(
                    title = "Funciones Complejas",
                    definition = "Las funciones complejas son funciones que toman números complejos como entrada y producen números complejos como salida, extendiendo el concepto de funciones reales al plano complejo.",
                    terms = """
                • Variable compleja
                • Función analítica
                • Derivada compleja
                • Integral compleja
                • Singularidad
                • Residuo
                • Transformación conforme
            """.trimIndent(),
                    description = """
                Definición:
                Una función f: ℂ → ℂ asigna a cada número complejo z otro número complejo w = f(z).

                Funciones elementales:
                1. Polinomios: P(z) = a₀ + a₁z + a₂z² + ... + aₙzⁿ
                2. Funciones racionales: R(z) = P(z) / Q(z)
                3. Función exponencial: e^z = e^x(cos y + i sin y), donde z = x + yi
                4. Funciones trigonométricas:
                   sin z = (e^(iz) - e^(-iz)) / (2i)
                   cos z = (e^(iz) + e^(-iz)) / 2

                Derivada compleja:
                f'(z) = lim(h→0) [f(z+h) - f(z)] / h
                (Si este límite existe, f es analítica en z)

                Condiciones de Cauchy-Riemann:
                Para f(z) = u(x,y) + iv(x,y) ser analítica:
                ∂u/∂x = ∂v/∂y y ∂u/∂y = -∂v/∂x

                Ejemplo:
                Analizar la analiticidad de f(z) = z²

                f(z) = (x + yi)² = (x² - y²) + (2xy)i
                u(x,y) = x² - y²
                v(x,y) = 2xy

                Verificando las condiciones de Cauchy-Riemann:
                ∂u/∂x = 2x = ∂v/∂y = 2x
                ∂u/∂y = -2y = -∂v/∂x = -2y

                Las condiciones se cumplen, por lo tanto f(z) = z² es analítica en todo ℂ.

                Aplicaciones:
                • Análisis complejo: teorema del residuo para cálculo de integrales
                • Aerodinámica: transformaciones conformes para flujo potencial
                • Teoría de campos: funciones armónicas y problemas de valor de contorno
                • Procesamiento de señales: análisis de Fourier y transformada Z
            """.trimIndent()
                )
            ),
            imageUrl = R.drawable.numero,
            isFavorite = false
        ),
        Subject(
            title = "Series y Secuencias",
            description = "Fundamentos y aplicaciones de series y secuencias matemáticas, cubriendo conceptos clave y ejemplos prácticos.",
            amount = "20 temas",
            topics = listOf(
                Topic(
                    title = "Secuencias",
                    definition = "Una secuencia es una lista ordenada de números que sigue un patrón específico. Cada número en la secuencia se llama término.",
                    terms = """
                • Término
                • Progresión aritmética
                • Progresión geométrica
                • Sucesión
                • Término general
            """.trimIndent(),
                    description = """
                Progresión aritmética:
                Una secuencia en la que cada término después del primero se obtiene sumando un número constante (d) al término anterior.
                Fórmula: aₙ = a₁ + (n-1)d
                Ejemplo:
                Para una secuencia comenzando en 2 con una diferencia de 3:
                2, 5, 8, 11, 14, ...
                El 10º término: a₁₀ = 2 + (10-1)3 = 29

                Progresión geométrica:
                Una secuencia en la que cada término después del primero se obtiene multiplicando el término anterior por una constante (r).
                Fórmula: aₙ = a₁ * r^(n-1)
                Ejemplo:
                Para una secuencia comenzando en 3 con una razón de 2:
                3, 6, 12, 24, 48, ...
                El 5º término: a₅ = 3 * 2^(5-1) = 48

                Aplicaciones:
                • Análisis de series temporales
                • Finanzas: cálculos de intereses
                • Informática: algoritmos y estructuras de datos
            """.trimIndent()
                ),
                Topic(
                    title = "Series",
                    definition = "Una serie es la suma de los términos de una secuencia. Existen diferentes tipos de series dependiendo de la naturaleza de la secuencia.",
                    terms = """
                • Suma de serie
                • Serie aritmética
                • Serie geométrica
                • Convergencia
                • Divergencia
            """.trimIndent(),
                    description = """
                Serie aritmética:
                La suma de los términos de una progresión aritmética.
                Fórmula: Sₙ = n/2 * (a₁ + aₙ)
                Ejemplo:
                Para la secuencia 2, 5, 8, 11, 14, ...
                La suma de los primeros 5 términos: S₅ = 5/2 * (2 + 14) = 40

                Serie geométrica:
                La suma de los términos de una progresión geométrica.
                Fórmula: Sₙ = a₁ * (1 - rⁿ) / (1 - r) (para |r| < 1)
                Ejemplo:
                Para la secuencia 3, 6, 12, 24, 48, ...
                La suma de los primeros 5 términos: S₅ = 3 * (1 - 2⁵) / (1 - 2) = 93

                Aplicaciones:
                • Física: análisis de series en mecánica y electricidad
                • Economía: cálculos de amortización y anualidades
                • Matemáticas: resolución de ecuaciones diferenciales
            """.trimIndent()
                ),
                Topic(
                    title = "Series Infinitas",
                    definition = "Una serie infinita es la suma de infinitos términos de una secuencia. Estas series son fundamentales en análisis matemático.",
                    terms = """
                • Serie infinita
                • Convergencia
                • Divergencia
                • Serie de Taylor
                • Serie de Fourier
            """.trimIndent(),
                    description = """
                Convergencia y Divergencia:
                Una serie infinita converge si la suma de sus términos tiende a un número finito. Si no, diverge.
                Ejemplo:
                La serie geométrica infinita con |r| < 1 converge.
                S = a₁ / (1 - r)

                Serie de Taylor:
                Representación de una función como una serie infinita de potencias.
                f(x) = Σ (fⁿ(a) / n!) * (x - a)ⁿ
                Ejemplo:
                eˣ = 1 + x + x²/2! + x³/3! + ...

                Serie de Fourier:
                Representación de una función periódica como una suma de senos y cosenos.
                f(x) = a₀/2 + Σ [aₙ cos(nx) + bₙ sin(nx)]
                Ejemplo:
                f(x) = 2 sin(x) + 3 cos(2x) es una serie de Fourier.

                Aplicaciones:
                • Análisis matemático: estudio de funciones y sus propiedades
                • Física: análisis de ondas y vibraciones
                • Ingeniería: procesamiento de señales y control de sistemas
            """.trimIndent()
                ),
                Topic(
                    title = "Aplicaciones de Series y Secuencias",
                    definition = "Las series y secuencias tienen numerosas aplicaciones prácticas en diversas disciplinas, desde la ingeniería hasta la economía.",
                    terms = """
                • Modelado matemático
                • Análisis de señales
                • Finanzas
                • Teoría de números
                • Ingeniería
            """.trimIndent(),
                    description = """
                Aplicaciones prácticas:
                1. Finanzas:
                   Cálculo de intereses compuestos y anualidades.
                   Fórmula de interés compuesto: A = P(1 + r/n)^(nt)

                2. Ingeniería:
                   Análisis de sistemas y señales, diseño de filtros.
                   Análisis de Fourier en procesamiento de señales.

                3. Física:
                   Estudio de series en mecánica y electricidad.
                   Resolución de ecuaciones diferenciales mediante series de potencia.

                4. Informática:
                   Algoritmos de búsqueda y ordenación.
                   Análisis de complejidad computacional.

                5. Matemáticas:
                   Teoría de números y combinatoria.
                   Análisis de series y secuencias en teoría de números.

                Ejemplos:
                • Cálculo de la suma de una serie geométrica infinita en análisis de señales.
                • Uso de series de Taylor para aproximar funciones en ingeniería.
            """.trimIndent()
                )
            ),
            imageUrl = R.drawable.series,
            isFavorite = false
        )
        ,


    ))
    val subjects: LiveData<List<Subject>> get() = _subjects

    val favorites = _subjects.map { subjects -> subjects.filter { it.isFavorite } }

    fun toggleFavorite(subject: Subject) {
        _subjects.value = _subjects.value?.map { if (it == subject) it.copy(isFavorite = !it.isFavorite) else it }
    }
    val filteredSubjects: LiveData<List<Subject>> = _filter.switchMap { filter ->
        _subjects.map { subjects ->
            if (filter.isEmpty()) subjects else subjects.filter { it.title.contains(filter, ignoreCase = true) }
        }
    }

    fun setFilter(filter: String) {
        _filter.value = filter
    }

}

