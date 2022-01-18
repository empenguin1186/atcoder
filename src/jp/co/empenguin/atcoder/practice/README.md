# URL
https://qiita.com/e869120/items/eb50fdaece12be418faa

# 反省点

## Problem3

- 終了時のcurrentの値を更新するのを忘れていた。**最後の要素まで判定の対象とする。**

## Problem4
- 𝑁 ≤ 100, 𝐴𝑖,𝑗 ≤ 108 なので答えは 10^10 まであり得てしまう。int 型は 2.14 × 109 程度まで。

