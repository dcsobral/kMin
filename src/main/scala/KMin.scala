object KMin { 
    def kMin(a1: Array[Int], a2: Array[Int], n: Int): Int = {
      def select(n2: Int) = n2 match {
        case `n` => a2(n - 1)
        case 0   => a1(n - 1)
        case _   => if (n % 2 == 1) a1(n - n2 - 1) max a2(n2 - 1)
                    else            a1(n - n2 - 1) min a2(n2 - 1)
      }
      
      def recurse(top: Int, bottom: Int): Int = {
        if (top == bottom) select(top)
        else {
          val x = (bottom + top) / 2 max bottom + 1
          if (a1(n - x) <= a2(x - 1)) recurse (x - 1, bottom)
          else recurse(top, x)
        }
      }
      
      recurse(n min a2.size, 0 max n - a1.size)
    }
}
