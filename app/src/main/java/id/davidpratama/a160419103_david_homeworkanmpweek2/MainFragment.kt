package id.davidpratama.a160419103_david_homeworkanmpweek2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var score = 0;
        var hasil = randomNumber()
        btnSubmit.setOnClickListener {
            var answer : Int = txtTrueOrFalseAnswer.text.toString().toInt();

            if(hasil == answer){
                score +=1;
                txtScore.text = "Score: $score";
                hasil = randomNumber();
                txtTrueOrFalseAnswer.setText("");
            }
            else{
                val action = MainFragmentDirections.actionMainfragment(score);
                Navigation.findNavController(it).navigate(action);
            }
        }
    }

    fun randomNumber() : Int{
        val number1 = (0..100).random();
        val number2 = (0..100).random();

        txtQuestion.text = "$number1 + $number2";

        var result = number1 + number2;
        return result;
    }
}