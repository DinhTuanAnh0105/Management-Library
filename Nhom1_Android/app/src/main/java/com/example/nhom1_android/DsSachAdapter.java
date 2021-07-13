package com.example.nhom1_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DsSachAdapter extends BaseAdapter {
        private DsSach context;
        private LayoutInflater inflater;
        private ArrayList<DsSachClass> listSach;
        public DsSachAdapter(DsSach context, ArrayList<DsSachClass> listSach) {
            this.context = context;
            this.listSach = listSach;
        }
        public int getCount() {
            return listSach.size();
        }

        @Override
        public Object getItem(int position) {
            return listSach.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(inflater == null)
            {
                inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            if(convertView == null)
            {
                convertView = inflater.inflate(R.layout.row_them_sach,null);
            }
            TextView txtTenSach=(TextView)convertView.findViewById(R.id.txtTenSach);
            TextView txtTG=(TextView)convertView.findViewById(R.id.txtTenTG);
            ImageView icon_sach=(ImageView)convertView.findViewById(R.id.icon_sach);
            ImageView SuaSach=(ImageView)convertView.findViewById(R.id.SuaSach);
            ImageView XoaSach=(ImageView)convertView.findViewById(R.id.XoaSach);
            final DsSachClass DsSach= listSach.get(position);
            txtTenSach.setText(DsSach.getTenS());
            txtTG.setText(DsSach.getTenTG());
            XoaSach.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.dialogDelete(DsSach.getMaS());
                }
            });

            SuaSach.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.dialogUpdate(DsSach.getMaS(), DsSach.getTenS(), DsSach.getTenTG(), DsSach.getViTri(), DsSach.getSl(), DsSach.getNamxb(), DsSach.getTinhtrang());

                }
            });
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v ) {
                    context.dialogChiTiet(DsSach.getMaS(), DsSach.getTenS(), DsSach.getTenTG(), DsSach.getViTri(), DsSach.getSl(), DsSach.getNamxb(), DsSach.getTinhtrang());
                }
            });
            return convertView;
        }
}
