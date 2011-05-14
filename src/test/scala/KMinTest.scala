import org.scalacheck._
import Prop._
import KMin._

object KMinTest extends Properties("logN KMin") {
    property("kMin finds the kth element of two sorted arrays") = forAll { (a1: Array[Int], a2: Array[Int], n: Int) => 
        (a1.size > 0 && a2.size > 0 && n >= 0) ==> { 
            val k = n % (a1.size + a2.size) + 1
            kMin(a1.sorted, a2.sorted, k) == (a1 ++ a2).sorted.apply(k - 1) 
        } :| "val a1 = Array(%s)\nval a2 = Array(%s)\nval n = %d\nval kMin = %d\n".format(
             a1.sorted.mkString(", "), 
             a2.sorted.mkString(", "), 
             n % (a1.size + a2.size) + 1, 
             kMin(a1.sorted, a2.sorted, n % (a1.size + a2.size) + 1)) 
    }
}

