akkanur
=======

The educative value of this project is 2-fold :

-  Better understand neural networks design, their learning dynamics and applications
-  Learn concurrent programming based on the actor model using the Akka library and the Scala language

## Actors and Neural Networks ?

The perceptron is a simple computing unit that applies a non-linearity to a weighting of its inputs to produce a new output.
It is therefore a good fit for the actor model where actors embed behavior, state, supervision and communicate by passing
immutable messages to each other. That idea was actually implemented by Wil Chung in one of his [Erlang projects](https://github.com/iamwilhelm/erlang_ann).

## Long-term short memory

The first example I would like to build is a specific kind of Recurrent Neural Network called LSTM (Long-term short memory).
There are already good implementations ([CURRENNT](http://ehc.ac/projects/currennt/files/), [PyBrain](http://pybrain.org/docs/))
of these but not so many good examples.

