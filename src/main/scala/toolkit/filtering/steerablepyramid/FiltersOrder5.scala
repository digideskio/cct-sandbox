/*
 * (c) Copyright 2016 Hewlett Packard Enterprise Development LP
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package toolkit.filtering.steerablepyramid

import libcog._

/** Filters for the order-5 Steerable Pyramid, ported from Matlab code.
  * (http://www.cns.nyu.edu/~eero/steerpyr/)
  *
  * @author Greg Snider
  */

object FiltersOrder5 extends Filters {
  val harmonics = Array(1, 3, 5)

  val mtx = toScalarField(Matrix(
    Array(0.3333f,   0.2887f,    0.1667f,    0.0000f,   -0.1667f,   -0.2887f),
    Array(0.0000f,    0.1667f,    0.2887f,    0.3333f,    0.2887f,    0.1667f),
    Array(0.3333f,   -0.0000f,   -0.3333f,   -0.0000f,    0.3333f,   -0.0000f),
    Array(0.0000f,    0.3333f,    0.0000f,   -0.3333f,    0.0000f,    0.3333f),
    Array(0.3333f,   -0.2887f,    0.1667f,   -0.0000f,   -0.1667f,    0.2887f),
    Array(-0.0000f,   0.1667f,   -0.2887f,    0.3333f,   -0.2887f,    0.1667f)
  ))

  val highpass0 = toScalarField(Matrix(
    Array(-0.00033429f, -0.00113093f, -0.00171484f, -0.00133542f, -0.00080639f, -0.00133542f, -0.00171484f, -0.00113093f, -0.00033429f),
    Array(-0.00113093f, -0.00350017f, -0.00243812f, 0.00631653f, 0.01261227f, 0.00631653f, -0.00243812f, -0.00350017f, -0.00113093f),
    Array(-0.00171484f, -0.00243812f, -0.00290081f, -0.00673482f, -0.00981051f, -0.00673482f, -0.00290081f, -0.00243812f, -0.00171484f),
    Array(-0.00133542f, 0.00631653f, -0.00673482f, -0.07027679f, -0.11435863f, -0.07027679f, -0.00673482f, 0.00631653f, -0.00133542f),
    Array(-0.00080639f, 0.01261227f, -0.00981051f, -0.11435863f, 0.81380200f, -0.11435863f, -0.00981051f, 0.01261227f, -0.00080639f),
    Array(-0.00133542f, 0.00631653f, -0.00673482f, -0.07027679f, -0.11435863f, -0.07027679f, -0.00673482f, 0.00631653f, -0.00133542f),
    Array(-0.00171484f, -0.00243812f, -0.00290081f, -0.00673482f, -0.00981051f, -0.00673482f, -0.00290081f, -0.00243812f, -0.00171484f),
    Array(-0.00113093f, -0.00350017f, -0.00243812f, 0.00631653f, 0.01261227f, 0.00631653f, -0.00243812f, -0.00350017f, -0.00113093f),
    Array(-0.00033429f, -0.00113093f, -0.00171484f, -0.00133542f, -0.00080639f, -0.00133542f, -0.00171484f, -0.00113093f, -0.00033429f)
  ))


  val lowpass0 = toScalarField(Matrix(
    Array(0.00341614f, -0.01551246f, -0.03848215f, -0.01551246f, 0.00341614f),
    Array(-0.01551246f, 0.05586982f, 0.15925570f, 0.05586982f, -0.01551246f),
    Array(-0.03848215f, 0.15925570f, 0.40304148f, 0.15925570f, -0.03848215f),
    Array(-0.01551246f, 0.05586982f, 0.15925570f, 0.05586982f, -0.01551246f),
    Array(0.00341614f, -0.01551246f, -0.03848215f, -0.01551246f, 0.00341614f)
  ))

  val lowpass = toScalarField(Matrix(
    Array(0.00085404f, -0.00244917f, -0.00387812f, -0.00944432f, -0.00962054f, -0.00944432f, -0.00387812f, -0.00244917f, 0.00085404f),
    Array(-0.00244917f, -0.00523281f, -0.00661117f, 0.00410600f, 0.01002988f, 0.00410600f, -0.00661117f, -0.00523281f, -0.00244917f),
    Array(-0.00387812f, -0.00661117f, 0.01396746f, 0.03277038f, 0.03981393f, 0.03277038f, 0.01396746f, -0.00661117f, -0.00387812f),
    Array(-0.00944432f, 0.00410600f, 0.03277038f, 0.06426333f, 0.08169618f, 0.06426333f, 0.03277038f, 0.00410600f, -0.00944432f),
    Array(-0.00962054f, 0.01002988f, 0.03981393f, 0.08169618f, 0.10096540f, 0.08169618f, 0.03981393f, 0.01002988f, -0.00962054f),
    Array(-0.00944432f, 0.00410600f, 0.03277038f, 0.06426333f, 0.08169618f, 0.06426333f, 0.03277038f, 0.00410600f, -0.00944432f),
    Array(-0.00387812f, -0.00661117f, 0.01396746f, 0.03277038f, 0.03981393f, 0.03277038f, 0.01396746f, -0.00661117f, -0.00387812f),
    Array(-0.00244917f, -0.00523281f, -0.00661117f, 0.00410600f, 0.01002988f, 0.00410600f, -0.00661117f, -0.00523281f, -0.00244917f),
    Array(0.00085404f, -0.00244917f, -0.00387812f, -0.00944432f, -0.00962054f, -0.00944432f, -0.00387812f, -0.00244917f, 0.00085404f)
  ) * 2.0f)

  val bandpass: Array[ScalarField] = Array(
    toScalarField(Matrix(
      Array(0.00277643f, 0.00496194f, 0.01026699f, 0.01455399f, 0.01026699f, 0.00496194f, 0.00277643f),
      Array(-0.00986904f, -0.00893064f, 0.01189859f, 0.02755155f, 0.01189859f, -0.00893064f, -0.00986904f),
      Array(-0.01021852f, -0.03075356f, -0.08226445f, -0.11732297f, -0.08226445f, -0.03075356f, -0.01021852f),
      Array(0.00000000f, 0.00000000f, 0.00000000f, 0.00000000f, 0.00000000f, 0.00000000f, 0.00000000f),
      Array(0.01021852f, 0.03075356f, 0.08226445f, 0.11732297f, 0.08226445f, 0.03075356f, 0.01021852f),
      Array(0.00986904f, 0.00893064f, -0.01189859f, -0.02755155f, -0.01189859f, 0.00893064f, 0.00986904f),
      Array(-0.00277643f, -0.00496194f, -0.01026699f, -0.01455399f, -0.01026699f, -0.00496194f, -0.00277643f)
    )),
    toScalarField(Matrix(
      Array(-0.00343249f, -0.00640815f, -0.00073141f, 0.01124321f, 0.00182078f, 0.00285723f, 0.01166982f),
      Array(-0.00358461f, -0.01977507f, -0.04084211f, -0.00228219f, 0.03930573f, 0.01161195f, 0.00128000f),
      Array(0.01047717f, 0.01486305f, -0.04819057f, -0.12227230f, -0.05394139f, 0.00853965f, -0.00459034f),
      Array(0.00790407f, 0.04435647f, 0.09454202f, -0.00000000f, -0.09454202f, -0.04435647f, -0.00790407f),
      Array(0.00459034f, -0.00853965f, 0.05394139f, 0.12227230f, 0.04819057f, -0.01486305f, -0.01047717f),
      Array(-0.00128000f, -0.01161195f, -0.03930573f, 0.00228219f, 0.04084211f, 0.01977507f, 0.00358461f),
      Array(-0.01166982f, -0.00285723f, -0.00182078f, -0.01124321f, 0.00073141f, 0.00640815f, 0.00343249f)
    )),
    toScalarField(Matrix(
      Array(0.00343249f, 0.00358461f, -0.01047717f, -0.00790407f, -0.00459034f, 0.00128000f, 0.01166982f),
      Array(0.00640815f, 0.01977507f, -0.01486305f, -0.04435647f, 0.00853965f, 0.01161195f, 0.00285723f),
      Array(0.00073141f, 0.04084211f, 0.04819057f, -0.09454202f, -0.05394139f, 0.03930573f, 0.00182078f),
      Array(-0.01124321f, 0.00228219f, 0.12227230f, -0.00000000f, -0.12227230f, -0.00228219f, 0.01124321f),
      Array(-0.00182078f, -0.03930573f, 0.05394139f, 0.09454202f, -0.04819057f, -0.04084211f, -0.00073141f),
      Array(-0.00285723f, -0.01161195f, -0.00853965f, 0.04435647f, 0.01486305f, -0.01977507f, -0.00640815f),
      Array(-0.01166982f, -0.00128000f, 0.00459034f, 0.00790407f, 0.01047717f, -0.00358461f, -0.00343249f)
    )),
    toScalarField(Matrix(
      Array(-0.00277643f, 0.00986904f, 0.01021852f, -0.00000000f, -0.01021852f, -0.00986904f, 0.00277643f),
      Array(-0.00496194f, 0.00893064f, 0.03075356f, -0.00000000f, -0.03075356f, -0.00893064f, 0.00496194f),
      Array(-0.01026699f, -0.01189859f, 0.08226445f, -0.00000000f, -0.08226445f, 0.01189859f, 0.01026699f),
      Array(-0.01455399f, -0.02755155f, 0.11732297f, -0.00000000f, -0.11732297f, 0.02755155f, 0.01455399f),
      Array(-0.01026699f, -0.01189859f, 0.08226445f, -0.00000000f, -0.08226445f, 0.01189859f, 0.01026699f),
      Array(-0.00496194f, 0.00893064f, 0.03075356f, -0.00000000f, -0.03075356f, -0.00893064f, 0.00496194f),
      Array(-0.00277643f, 0.00986904f, 0.01021852f, -0.00000000f, -0.01021852f, -0.00986904f, 0.00277643f)
    )),
    toScalarField(Matrix(
      Array(-0.01166982f, -0.00128000f, 0.00459034f, 0.00790407f, 0.01047717f, -0.00358461f, -0.00343249f),
      Array(-0.00285723f, -0.01161195f, -0.00853965f, 0.04435647f, 0.01486305f, -0.01977507f, -0.00640815f),
      Array(-0.00182078f, -0.03930573f, 0.05394139f, 0.09454202f, -0.04819057f, -0.04084211f, -0.00073141f),
      Array(-0.01124321f, 0.00228219f, 0.12227230f, -0.00000000f, -0.12227230f, -0.00228219f, 0.01124321f),
      Array(0.00073141f, 0.04084211f, 0.04819057f, -0.09454202f, -0.05394139f, 0.03930573f, 0.00182078f),
      Array(0.00640815f, 0.01977507f, -0.01486305f, -0.04435647f, 0.00853965f, 0.01161195f, 0.00285723f),
      Array(0.00343249f, 0.00358461f, -0.01047717f, -0.00790407f, -0.00459034f, 0.00128000f, 0.01166982f)
    )),
    toScalarField(Matrix(
      Array(-0.01166982f, -0.00285723f, -0.00182078f, -0.01124321f, 0.00073141f, 0.00640815f, 0.00343249f),
      Array(-0.00128000f, -0.01161195f, -0.03930573f, 0.00228219f, 0.04084211f, 0.01977507f, 0.00358461f),
      Array(0.00459034f, -0.00853965f, 0.05394139f, 0.12227230f, 0.04819057f, -0.01486305f, -0.01047717f),
      Array(0.00790407f, 0.04435647f, 0.09454202f, -0.00000000f, -0.09454202f, -0.04435647f, -0.00790407f),
      Array(0.01047717f, 0.01486305f, -0.04819057f, -0.12227230f, -0.05394139f, 0.00853965f, -0.00459034f),
      Array(-0.00358461f, -0.01977507f, -0.04084211f, -0.00228219f, 0.03930573f, 0.01161195f, 0.00128000f),
      Array(-0.00343249f, -0.00640815f, -0.00073141f, 0.01124321f, 0.00182078f, 0.00285723f, 0.01166982f)
    ))
  )
}
