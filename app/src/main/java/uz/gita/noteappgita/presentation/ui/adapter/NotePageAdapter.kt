package uz.gita.noteappgita.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.gita.noteAppGita.R
import uz.gita.noteAppGita.databinding.ItemNoteBinding
import uz.gita.noteappgita.data.model.NoteData

class NotePageAdapter : ListAdapter<NoteData, NotePageAdapter.MyViewHolder>(MyDiffUtil) {
    private var clickItemListener: ((NoteData) -> Unit)? = null

    inner class MyViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.click2.setOnClickListener {
                clickItemListener?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun bind() {
            binding.title.text = getItem(absoluteAdapterPosition).title
            binding.description.fromHtml(getItem(absoluteAdapterPosition).note!!)
            binding.time.text = getItem(absoluteAdapterPosition).time.toString()
        }
    }

    object MyDiffUtil : DiffUtil.ItemCallback<NoteData>() {
        override fun areItemsTheSame(oldItem: NoteData, newItem: NoteData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteData, newItem: NoteData): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return MyViewHolder(ItemNoteBinding.bind(view))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind()
    }

    fun setClickItemListener(block: (NoteData) -> Unit) {
        clickItemListener = block
    }
}