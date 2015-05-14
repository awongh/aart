(ns aart.flower_of_life
  (:require [quil.core :as q]))

(defn radians [cnt ccount]
  (* cnt (/ (* 2 (Math/PI)) ccount)))

(defn circle [cnt ccount radius origin ]
   ;formula for graphing a circle
   ;x = cx + (r * cos(a)) and y = cy + (r * sin(a))
  (def xpos (+ (first origin) (* radius (Math/cos(radians cnt ccount)))))
  (def ypos (+ (last origin) (* radius (Math/sin(radians cnt ccount)))))
  ;calc the x axis

  (q/no-fill)
  (q/ellipse xpos ypos (* 2 radius) (* 2 radius))

  nil
  )

(defn draw []
  (let [radius 50
        ccount 6
        xpos (/ (q/width) 2)
        ypos (/ (q/width) 2)
        origin [xpos ypos]]

    ;the first circle
    (q/no-fill)
    (q/ellipse xpos ypos (* 2 radius) (* 2 radius))

    (loop [cnt 6 foo nil]
      (if (zero? cnt) nil
      (recur (dec cnt) (circle cnt ccount radius origin))
    )))

  (q/save "yourmomdoesitall.png")

  (q/no-loop))

(q/defsketch flower_of_life
  :title "flower of life"
  :size [500 500]
  :features [:keep-on-top]
  :draw draw)
