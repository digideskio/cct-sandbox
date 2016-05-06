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

/** Filters for the order-0 Steerable Pyramid, ported from Matlab code.
  * (http://www.cns.nyu.edu/~eero/steerpyr/)
  *
  * @author Greg Snider
  */

object FiltersOrder0 extends Filters {
  val harmonics = Array(0)

  val lowpass0 = toScalarField(Matrix(
    Array(-4.514000e-04f, -1.137100e-04f, -3.725800e-04f, -3.743860e-03f, -3.725800e-04f, -1.137100e-04f, -4.514000e-04f),
    Array(-1.137100e-04f, -6.119520e-03f, -1.344160e-02f, -7.563200e-03f, -1.344160e-02f, -6.119520e-03f, -1.137100e-04f),
    Array(-3.725800e-04f, -1.344160e-02f, 6.441488e-02f, 1.524935e-01f, 6.441488e-02f, -1.344160e-02f, -3.725800e-04f),
    Array(-3.743860e-03f, -7.563200e-03f, 1.524935e-01f, 3.153017e-01f, 1.524935e-01f, -7.563200e-03f, -3.743860e-03f),
    Array(-3.725800e-04f, -1.344160e-02f, 6.441488e-02f, 1.524935e-01f, 6.441488e-02f, -1.344160e-02f, -3.725800e-04f),
    Array(-1.137100e-04f, -6.119520e-03f, -1.344160e-02f, -7.563200e-03f, -1.344160e-02f, -6.119520e-03f, -1.137100e-04f),
    Array(-4.514000e-04f, -1.137100e-04f, -3.725800e-04f, -3.743860e-03f, -3.725800e-04f, -1.137100e-04f, -4.514000e-04f)
  ))

  val lowpass = toScalarField(Matrix(
    Array(-2.257000e-04f, -8.064400e-04f, -5.686000e-05f, 8.741400e-04f, -1.862800e-04f, -1.031640e-03f, -1.871920e-03f, -1.031640e-03f, -1.862800e-04f, 8.741400e-04f, -5.686000e-05f, -8.064400e-04f, -2.257000e-04f),
    Array(-8.064400e-04f, 1.417620e-03f, -1.903800e-04f, -2.449060e-03f, -4.596420e-03f, -7.006740e-03f, -6.948900e-03f, -7.006740e-03f, -4.596420e-03f, -2.449060e-03f, -1.903800e-04f, 1.417620e-03f, -8.064400e-04f),
    Array(-5.686000e-05f, -1.903800e-04f, -3.059760e-03f, -6.401000e-03f, -6.720800e-03f, -5.236180e-03f, -3.781600e-03f, -5.236180e-03f, -6.720800e-03f, -6.401000e-03f, -3.059760e-03f, -1.903800e-04f, -5.686000e-05f),
    Array(8.741400e-04f, -2.449060e-03f, -6.401000e-03f, -5.260020e-03f, 3.938620e-03f, 1.722078e-02f, 2.449600e-02f, 1.722078e-02f, 3.938620e-03f, -5.260020e-03f, -6.401000e-03f, -2.449060e-03f, 8.741400e-04f),
    Array(-1.862800e-04f, -4.596420e-03f, -6.720800e-03f, 3.938620e-03f, 3.220744e-02f, 6.306262e-02f, 7.624674e-02f, 6.306262e-02f, 3.220744e-02f, 3.938620e-03f, -6.720800e-03f, -4.596420e-03f, -1.862800e-04f),
    Array(-1.031640e-03f, -7.006740e-03f, -5.236180e-03f, 1.722078e-02f, 6.306262e-02f, 1.116388e-01f, 1.348999e-01f, 1.116388e-01f, 6.306262e-02f, 1.722078e-02f, -5.236180e-03f, -7.006740e-03f, -1.031640e-03f),
    Array(-1.871920e-03f, -6.948900e-03f, -3.781600e-03f, 2.449600e-02f, 7.624674e-02f, 1.348999e-01f, 1.576508e-01f, 1.348999e-01f, 7.624674e-02f, 2.449600e-02f, -3.781600e-03f, -6.948900e-03f, -1.871920e-03f),
    Array(-1.031640e-03f, -7.006740e-03f, -5.236180e-03f, 1.722078e-02f, 6.306262e-02f, 1.116388e-01f, 1.348999e-01f, 1.116388e-01f, 6.306262e-02f, 1.722078e-02f, -5.236180e-03f, -7.006740e-03f, -1.031640e-03f),
    Array(-1.862800e-04f, -4.596420e-03f, -6.720800e-03f, 3.938620e-03f, 3.220744e-02f, 6.306262e-02f, 7.624674e-02f, 6.306262e-02f, 3.220744e-02f, 3.938620e-03f, -6.720800e-03f, -4.596420e-03f, -1.862800e-04f),
    Array(8.741400e-04f, -2.449060e-03f, -6.401000e-03f, -5.260020e-03f, 3.938620e-03f, 1.722078e-02f, 2.449600e-02f, 1.722078e-02f, 3.938620e-03f, -5.260020e-03f, -6.401000e-03f, -2.449060e-03f, 8.741400e-04f),
    Array(-5.686000e-05f, -1.903800e-04f, -3.059760e-03f, -6.401000e-03f, -6.720800e-03f, -5.236180e-03f, -3.781600e-03f, -5.236180e-03f, -6.720800e-03f, -6.401000e-03f, -3.059760e-03f, -1.903800e-04f, -5.686000e-05f),
    Array(-8.064400e-04f, 1.417620e-03f, -1.903800e-04f, -2.449060e-03f, -4.596420e-03f, -7.006740e-03f, -6.948900e-03f, -7.006740e-03f, -4.596420e-03f, -2.449060e-03f, -1.903800e-04f, 1.417620e-03f, -8.064400e-04f),
    Array(-2.257000e-04f, -8.064400e-04f, -5.686000e-05f, 8.741400e-04f, -1.862800e-04f, -1.031640e-03f, -1.871920e-03f, -1.031640e-03f, -1.862800e-04f, 8.741400e-04f, -5.686000e-05f, -8.064400e-04f, -2.257000e-04f)
  ))

  val mtx = toScalarField(Matrix(Array(1.000000f)))

  val highpass0 = toScalarField(Matrix(
    Array(5.997200e-04f, -6.068000e-05f, -3.324900e-04f, -3.325600e-04f, -2.406600e-04f, -3.325600e-04f, -3.324900e-04f, -6.068000e-05f, 5.997200e-04f),
    Array(-6.068000e-05f, 1.263100e-04f, 4.927100e-04f, 1.459700e-04f, -3.732100e-04f, 1.459700e-04f, 4.927100e-04f, 1.263100e-04f, -6.068000e-05f),
    Array(-3.324900e-04f, 4.927100e-04f, -1.616650e-03f, -1.437358e-02f, -2.420138e-02f, -1.437358e-02f, -1.616650e-03f, 4.927100e-04f, -3.324900e-04f),
    Array(-3.325600e-04f, 1.459700e-04f, -1.437358e-02f, -6.300923e-02f, -9.623594e-02f, -6.300923e-02f, -1.437358e-02f, 1.459700e-04f, -3.325600e-04f),
    Array(-2.406600e-04f, -3.732100e-04f, -2.420138e-02f, -9.623594e-02f, 8.554893e-01f, -9.623594e-02f, -2.420138e-02f, -3.732100e-04f, -2.406600e-04f),
    Array(-3.325600e-04f, 1.459700e-04f, -1.437358e-02f, -6.300923e-02f, -9.623594e-02f, -6.300923e-02f, -1.437358e-02f, 1.459700e-04f, -3.325600e-04f),
    Array(-3.324900e-04f, 4.927100e-04f, -1.616650e-03f, -1.437358e-02f, -2.420138e-02f, -1.437358e-02f, -1.616650e-03f, 4.927100e-04f, -3.324900e-04f),
    Array(-6.068000e-05f, 1.263100e-04f, 4.927100e-04f, 1.459700e-04f, -3.732100e-04f, 1.459700e-04f, 4.927100e-04f, 1.263100e-04f, -6.068000e-05f),
    Array(5.997200e-04f, -6.068000e-05f, -3.324900e-04f, -3.325600e-04f, -2.406600e-04f, -3.325600e-04f, -3.324900e-04f, -6.068000e-05f, 5.997200e-04f)
  ))

  val bandpass: Array[ScalarField] = Array(
    toScalarField(Matrix(
      Array(-9.066000e-05f, -1.738640e-03f, -4.942500e-03f, -7.889390e-03f, -1.009473e-02f, -7.889390e-03f, -4.942500e-03f, -1.738640e-03f, -9.066000e-05f),
      Array(-1.738640e-03f, -4.625150e-03f, -7.272540e-03f, -7.623410e-03f, -9.091950e-03f, -7.623410e-03f, -7.272540e-03f, -4.625150e-03f, -1.738640e-03f),
      Array(-4.942500e-03f, -7.272540e-03f, -2.129540e-02f, -2.435662e-02f, -3.487008e-02f, -2.435662e-02f, -2.129540e-02f, -7.272540e-03f, -4.942500e-03f),
      Array(-7.889390e-03f, -7.623410e-03f, -2.435662e-02f, -1.730466e-02f, -3.158605e-02f, -1.730466e-02f, -2.435662e-02f, -7.623410e-03f, -7.889390e-03f),
      Array(-1.009473e-02f, -9.091950e-03f, -3.487008e-02f, -3.158605e-02f, 9.464195e-01f, -3.158605e-02f, -3.487008e-02f, -9.091950e-03f, -1.009473e-02f),
      Array(-7.889390e-03f, -7.623410e-03f, -2.435662e-02f, -1.730466e-02f, -3.158605e-02f, -1.730466e-02f, -2.435662e-02f, -7.623410e-03f, -7.889390e-03f),
      Array(-4.942500e-03f, -7.272540e-03f, -2.129540e-02f, -2.435662e-02f, -3.487008e-02f, -2.435662e-02f, -2.129540e-02f, -7.272540e-03f, -4.942500e-03f),
      Array(-1.738640e-03f, -4.625150e-03f, -7.272540e-03f, -7.623410e-03f, -9.091950e-03f, -7.623410e-03f, -7.272540e-03f, -4.625150e-03f, -1.738640e-03f),
      Array(-9.066000e-05f, -1.738640e-03f, -4.942500e-03f, -7.889390e-03f, -1.009473e-02f, -7.889390e-03f, -4.942500e-03f, -1.738640e-03f, -9.066000e-05f)
    ))
  )
}
