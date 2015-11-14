(ns aart.flower_of_life
  (:require [quil.core :as q]))

(defn radians [i circle_count]
  (* i (/ (* 2 (Math/PI)) circle_count)))

(defn circle [i circle_count radius xorigin yorigin]
   ;formula for graphing a circle
   ;x = cx + (r * cos(a)) and y = cy + (r * sin(a))

  ;define x,y offset the x and y by the radians divided by the count
  (def xpos (+ xorigin (* radius (Math/cos(radians i circle_count)))))
  (def ypos (+ yorigin (* radius (Math/sin(radians i circle_count)))))

  (q/no-fill)
  (q/ellipse xpos ypos (* 2 radius) (* 2 radius))
  )

(defn draw []
  (let [radius 50
        circle_count 6
        xpos (/ (q/width) 2)
        ypos (/ (q/width) 2)]

    ;the first circle
    (q/no-fill)
    (q/ellipse xpos ypos (* 2 radius) (* 2 radius))

    (loop [i circle_count foo nil]
      (if (zero? i) nil

      ;pass the center of the circle: x,y
      (recur (dec i) (circle i circle_count radius xpos ypos))
    )))

  ;(q/save "yourmom.png")

  (q/no-loop))

(q/defsketch flower_of_life
  :title "flower of life"
  :size [500 500]
  :features [:keep-on-top]
  :draw draw)
