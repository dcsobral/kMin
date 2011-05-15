object KMin { 
    def kMin(a1: Array[Int], a2: Array[Int], k: Int): Int = {
      def select(k2: Int) = k2 match {
        case `k` => a2(k - 1)
        case 0   => a1(k - 1)
        case _   => a1(k - k2 - 1) max a2(k2 - 1)
      }
      
      def recurse(top: Int, bottom: Int): Int = {
        if (top == bottom) select(top)
        else {
          val x = (bottom + top) / 2 max bottom + 1
          if (a1(k - x) <= a2(x - 1)) recurse (x - 1, bottom)
          else recurse(top, x)
        }
      }
      
      recurse(k min a2.size, 0 max k - a1.size)
    }
}
