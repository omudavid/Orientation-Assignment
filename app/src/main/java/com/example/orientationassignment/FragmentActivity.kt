package com.example.orientationassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        btnAddFragment.setOnClickListener {
            var bundle = Bundle()
            var backCount = supportFragmentManager.backStackEntryCount
            var fragment = Fragment()
            bundle.putInt("BACK_COUNT",backCount+1)


            when(backCount){
                0 ->{ fragment = FragmentOne()
                    fragment.setArguments(bundle)
                }
                1 ->{ fragment = FragmentTwo()
                    fragment.setArguments(bundle)
                }
                2 ->{fragment = FragmentThree()
                    fragment.setArguments(bundle)
                }

                else -> Toast.makeText(this,"No Fragments To Add",Toast.LENGTH_SHORT).show()

            }

            if(backCount<3) fragmentMaker(fragment)


        }

        btnRemoveFragment.setOnClickListener {
            supportFragmentManager.popBackStack()
        }
    }

    private fun fragmentMaker(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            addToBackStack(null)
            replace(R.id.frameLayout,fragment)
            commit()
        }
    }
}